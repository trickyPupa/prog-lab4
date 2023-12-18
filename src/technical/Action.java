package technical;

public class Action {
//    ACT("делает"),
//    OPEN("открывает"),
//    TALK("говорит"),
//    ASK("спрашивает"),
//    THINK("думает"),
//    DAMAGE("наносит урон");
//    лечит
//    успокаивает
//    бежит
//    летит

    public static final String[] modes = {"оригинально", "смешно", "хорошо", "по-комариному", "приглушенно",
            "внимательно", "лукаво", "тихо", ""};

    private final String label;
    private Status effect = Status.NO;
    private long force = 0;
    private IApplyEffect applyEffect;

    public Action(String label){
        this.label = label;
        this.applyEffect = new DefaultEffect();
    }
    public Action(String label, Status effect, int force){
        this.label = label;
        this.effect = effect;
        this.force = force;
    }
    public Action(String label, IApplyEffect applyEffectMethod){
        this.label = label;
        this.applyEffect = applyEffectMethod;
    }
    public Action(String label, IApplyEffect applyEffectMethod, Status effect, int force){
        this.label = label;
        this.applyEffect = applyEffectMethod;
        this.effect = effect;
        this.force = force;
    }
    public void setForce(int f){
        force = f;
    }
    public String getLabel(){
        return label;
    }
    public Status getEffect(){
        return effect;
    }
    public IApplyEffect getApplyEffect(){
        return applyEffect;
    }
    public void setEffect(Status ef){
        effect = ef;
    }
    public String getStatement(){
        return label;
    }

    public boolean check(long force2){
        return force == 0 || force <= force2;
    }

    @Override
    public String toString() {
        String ans = "Действие: \"" + getLabel() + "\"";
        return ans;
    }
}
