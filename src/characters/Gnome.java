package characters;

import other.Place;
import technical.*;
import technical.exceptions.DeathException;

import java.util.Objects;

public abstract class Gnome extends Statused {
    public static final Action FLY = new Action("летит", (actor, target, effect) -> {
        if(!actor.is_floating) {
            System.out.println(actor + " взлетает");
            actor.floating();
        }
        }, Status.NO, 0);
    public static final Action ATTACK = new Action("атакует", (actor, target, effect) -> {
        target.takeDamage(5 + (int) (Math.random() * (4 + Math.max(actor.getForce() - target.getForce(), 0))));
        target.flip();
        actor.flip();
    }, Status.SCARE, 5);

    protected Place location;
    public boolean is_floating = false;
    protected Legs legs;

    protected class Legs implements Floatable {
        private boolean injured = false;
        private final int length;

        public Legs(int length){
            this.length = length;
        }
        public void flip() {
            System.out.println(this + " задрались вверх");
        }

        @Override
        public void crash() {
            System.out.println(Gnome.this + " ударился ногами");
            if (Math.random() < 0.2 + (length * 0.004)) injure();
        }

        @Override
        public void crash(Statused into) {
            System.out.println(Gnome.this + " ударился ногами о " + into.getName());
            if (Math.random() < 0.2 + (length * 0.004)) injure();
        }

        @Override
        public void floating() {
            System.out.println(this + " плавают в воздухе");
        }

        public void injure(){
            injured = true;
            System.out.println(Gnome.this + " повредил свои ноги");
            Gnome.this.setStatus(Status.INJURED);
        }

        public boolean isInjured(){
            return injured;
        }

        @Override
        public String toString(){
            return "ноги " + Gnome.this;
        }

        @Override
        public boolean equals(Object o) {
            return this == o;
//            if (o == null || getClass() != o.getClass()) return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(this.toString());
        }
    }

    public Gnome(String nm, Place loc, int hp, int force){
        super(nm, hp, force);
        this.location = loc;
    }

    public String getLocation(){
        return this.location.toString();
    }

    public abstract void move(Place loc);
    public abstract void fail();

    @Override
    public void flip(){
        System.out.println(this + " переворачивается в воздухе");
        if (Math.random() < 0.3) this.crash();
    }

    public String presentation(){
        return this + ", находящийся в " + this.getLocation() + ",\tстатус: " + status.getLabel() + ",\tколичество здоровья: " + hp;
    }

    @Override
    public String toString() {
//        return this.getName();
        return "коротышка по имени " + this.getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Gnome gn = (Gnome) o;
        return Objects.equals(getName(), gn.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(name) + Objects.hash(status.getLabel()) + hp + force;
    }

    @Override
    public void floating() {
        is_floating = true;
        System.out.println(this + " плавает в воздухе");
        if (Math.random() < 0.3) this.flip();
        if (Math.random() < 0.3) this.crash();
    }

    @Override
    public void crash() {
        is_floating = false;
        String message = this + " врезается во что-то";
        if (Math.random() < 0.1) {
            takeDamage(1);
            message += " и получает 1 урон";
        }
        System.out.println(message);
    }

    @Override
    public void crash(Statused into) {
        is_floating = false;
        String message = this + " врезается в " + into.getName();
        if (Math.random() < 0.1) {
            takeDamage(1);
            message += " и получает 1 урон";
        }
        System.out.println(message);
    }

    @Override
    public boolean do_smth(Action action) {
        if (action.check(force)){
            action.getApplyEffect().applyEffect(this, this, action.getEffect());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement());
            return false;
        }
    }

    @Override
    public boolean do_smth(Action action, Statused target) {
        if (action.check(force)){
            action.getApplyEffect().applyEffect(this, target, action.getEffect());
            System.out.println(this + " успешно " + action.getStatement() + " " + target.getName());
            return true;
        } else{
            System.out.println(this + " безуспешно " + action.getStatement());
            return false;
        }
    }

    @Override
    public void takeDamage(int d) {
        if (d < hp && d > 0){
            hp -= d;
            force -= (int) (d * 0.1);
            if(hp < 10){
                setStatus(Status.ANXIETY);
            }
        } else if (d >= hp){
            hp = 0;
            setStatus(Status.DEAD);
            throw new DeathException(this + " погиб.");
        }
    }

    @Override
    public void heal() {
        hp += 5;
        force += 3;
        if (status == Status.INJURED) setStatus(Status.NO);
    }

    @Override
    public void setStatus(Status st) {
        if (st.getType() != Status.EntityType.ITEM && status != Status.DEAD){
            if (status == Status.CONFUSED && st == Status.CONFUSED) {
                takeDamage(1);
            } else if (st == Status.INJURED) {
                force -= 5;
            }
            if (status != st) System.out.println("Статус " + this + " изменился на " + st.getLabel());
            status = st;
            if(status == Status.DEAD) fail();
        }
    }
}
