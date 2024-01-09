import characters.Gnome;
import characters.SimpleGnome;
import characters.MainCharacter;
import other.Item;
import other.Place;
import technical.*;
import technical.exceptions.DeathException;
import technical.exceptions.StoryException;


/*Придя постепенно в себя, Знайка убедился, что висит в какой-то нелепой позе посреди комнаты, между полом и
потолком. Неподалеку от него повис кверху ножками стул, люстра висела в каком-то противоестественном состоянии:
не отвесно, как бывает всегда, а наискось, словно какая-то неведомая сила притягивала ее к стене; вокруг по всей
комнате плавали книги. Знайке показалось странным, что и стул, и книги не падают на пол, а как бы взвешены в
воздухе. Все это было похоже на состояние невесомости, которое Знайка наблюдал в кабине космического корабля во
время путешествия на Луну. Стараясь не делать резких движений, он попробовал поднять руку. Его удивило, что для
этого ему не потребовалось никакого усилия. Рука поднялась как бы сама собой. Она была легкая, как пушинка.
Знайка поднял другую руку. И эта рука словно не весила ничего. Ее даже как будто подталкивало что-то снизу. Теперь,
когда волнение его несколько улеглось, Знайка почувствовал во всем теле какую-то необычную легкость. Ему казалось,
что стоит только взмахнуть руками, и он начнет порхать по комнате, словно мотылек или какое-нибудь другое крылатое
насекомое. "Что же со мной случилось? -- в смятении думал Знайка. -- Одно из двух: либо я нахожусь в состоянии
невесомости, либо я сплю и все это мне во сне снится". Он принялся изо всех сил таращить глаза, стараясь проснуться,
но, убедившись, что и без того не спит, окончательно пришел в уныние и закричал жалобным голосом: Так как на помощь
никто не шел. Знайка решил поскорей выбраться из комнаты и посмотреть, что делают остальные друзья коротышки. Начав
осторожно делать руками и ногами плавательные движения, Знайка стал медленно перемещаться по воздуху и постепенно
доплыл до двери. Там он уцепился руками за притолоку и принялся изо всех сил толкать дверь ногами. Казалось бы,
открыть дверь -- дело нехитрое, однако в состоянии невесомости это не так просто, как кажется. Знайке пришлось
потратить немало усилий, прежде чем дверь оказалась открытой. Выбравшись наконец из комнаты и очутившись на
лестнице (вернее сказать, над лестницей), Знайка принялся раздумывать, как бы ему спуститься вниз. Каждый может
легко догадаться, что спускаться обычным способом, то есть сходя по ступенькам. Знайка теперь не мог, так как сила
тяжести уже не тянула его вниз и, сколько бы он ни перебирал ногами, это ни к чему бы не привело. В конце концов
Знайка все же придумал хороший способ. Дотянувшись до перил, он стал спускаться, цепляясь за перила руками. Наверно,
со стороны это выглядело очень смешно, потому что Знайкины ноги болтались в воздухе, как у комара, и по мере того
как он опускался все ниже, ноги его задирались все выше и он все больше перевертывался вниз головой. Спустившись
таким оригинальным способом с лестницы, Знайка очутился в коридоре перед дверью в столовую. Из-за двери доносились
какие-то приглушенные крики. Знайка прислушался и понял, что находившиеся в столовой коротышки чем-то встревожены.
После нескольких неудачных попыток Знайка отворил дверь и очутился в столовой. То, что он увидел, привело его в
изумление. Коротышки, собравшиеся в столовой, не сидели, как всегда, за столом, а плавали в различных позах по
воздуху. Вокруг них плавали стулья, скамейки, миски, тарелки, ложки. Тут же плавала большая алюминиевая кастрюля,
наполненная манной кашей. Увидев Знайку, коротышки подняли невероятный шум. А Незнайка сказал: С этими словами
Незнайка взмахнул кулаком и дал Шпунтику такого сильного подзатыльника, что Шпунтик завертелся волчком и полетел
через всю комнату. Незнайка тоже не удержался на месте и, полетев в противоположную сторону, стукнулся головой о
кастрюлю с кашей. От толчка жидкая манная каша выплеснулась прямо в лицо находившемуся неподалеку Пончику. Стараясь
избежать столкновения с плюющимся Пончиком и плывущими по воздуху комьями манной каши, коротышки принялись делать
резкие движения руками и ногами, в результате чего стали летать по комнате во всех направлениях, сталкиваясь друг с
другом и нанося друг ДРУГУ различные повреждения. Рассердившись, Знайка стукнул кулаком по столу, возле которого в
тот момент находился. От такого резкого движения Знайку самого перевернуло в воздухе и довольно сильно ушибло
затылком об угол стола. */


public class Main {
    public static void main(String[] args) {
        scene2();
//        test();
    }

    public static void scene2() {
        class GnomesList{
            public static final String[] gnome_names = {"Незнайка", "Винтик", "Шпунтик", "Сиропчик", "Пончик"};
            private SimpleGnome[] gnomes;

            public GnomesList(int len){
                gnomes = new SimpleGnome[len];
                for (int i = 0; i < len; i++){
                    gnomes[i] = new SimpleGnome(gnome_names[i % gnome_names.length]);
                }
            }
            public GnomesList(SimpleGnome[] list){
                gnomes = list;
            }
            public SimpleGnome getI(int i) {
                return gnomes[i];
            }
            public void floating(){
                for (SimpleGnome i : gnomes){
                    i.floating();
                }
            }
            public void simple_action(String text){
                for (SimpleGnome i : gnomes){
                    i.simple_action(text);
                }
            }
            public void chaos(Action action){
                for (int i = 0; i < gnomes.length; i++){
                    if (Math.random() < 0.3){
                        gnomes[i].do_smth(action, gnomes[(i + 1) % gnomes.length]);
                    }
                }
            }
            public int getLen(){
                return gnomes.length;
            }
        }

        MainCharacter znaika = new MainCharacter();

        GnomesList gnome_list = new GnomesList(new SimpleGnome[]{new SimpleGnome("Незнайка"),
                new SimpleGnome("Винтик"), new SimpleGnome("Шпунтик"), new SimpleGnome("Сиропчик"),
                new SimpleGnome("Пончик")});

        Item door = new Item("дверь", 2);
        Item railings = new Item("перила", 2);
        Item[] bedroom_items = {new Item("стул", 0), new Item("Война и мир. том 1", 0),
                new Item("Евангелие от Матвея", 0), new Item("люстра", 0)};
        Item[] kitchen_items = {new Item("стул", 0), new Item("скамья", 0),
                new Item("миска", 0), new Item("тарелка", 0),
                new Item("ложка", 0), new Item("кастрюля с кашей", 0),
                new Item("стол", 0)};

        IApplyEffect feeling_good = (actor, target, effect) -> {
            target.setStatus(Status.ELATION);
            target.heal();
        };

        try {
            IApplyEffect crash_into_func = new IApplyEffect() {
                int count = 0;
                @Override
                public void applyEffect(Statused actor, Statused target, Status effect) {
                    if (count > 5) {
                        System.out.println("Начася сущий ад");
                    }
                    else {
                        actor.crash(target);
                        target.crash(actor);
                        count++;
                    }
                }
            };
            Action crashes_into_action = new Action("врезается в", crash_into_func, Status.ANGER, 4);

            znaika.do_smth(new Action("почувствовал себя хорошо", feeling_good), true);

            znaika.do_smth(Gnome.FLY);
            znaika.think();

            for(Item i : bedroom_items){
                i.floating();
            }

            znaika.do_smth(new Action("постарался проснуться", (actor, target, effect) -> {
                if (Math.random() < 0.1){
                    actor.takeDamage(1);
                }
                target.setStatus(effect);
            }, Status.DESPAIR, 0), true);

            Action pull = new Action("тянется");
            pull.setForce(railings.getForce());
            znaika.do_smth(pull, railings, true);

            znaika.move(Place.STAIRS);
            znaika.do_smth(new Action("открывает"), door, true);

            znaika.move(Place.HALL);
            gnome_list.simple_action("тревожится");
            znaika.do_smth(new Action("открывает"), door, true);

            znaika.move(Place.DINING_ROOM);
            for (int i = 0; i < gnome_list.getLen(); i++){
                gnome_list.getI(i).floating();
                znaika.do_smth(new Action("видит"), gnome_list.getI(i));
                gnome_list.getI(i).do_smth(new Action("удивляет", new DefaultEffect(), Status.ASTONISHMENT, 2), znaika);
            }
            for(Item i : kitchen_items){
                i.floating();
            }

            Item temp = new Item("молчание", 0);
            temp.simple_action("повисло");

            gnome_list.getI(0).do_smth(Gnome.ATTACK, gnome_list.getI(1), true);

            gnome_list.getI(0).do_smth(crashes_into_action, kitchen_items[5], true);

            gnome_list.chaos(crashes_into_action);

            znaika.do_smth(crashes_into_action, kitchen_items[6], true);

        } catch (DeathException e){
            System.out.println(e.getMessage());
            System.out.println("Продолжать дальше нельзя");
        } catch (StoryException e){
            znaika.fail();
        }
        finally {
            System.out.println();
            System.out.println("Главный герой - " + znaika.presentation());
            System.out.println("Конец");
        }
    }

    public static void test(){
        MainCharacter znaika = new MainCharacter();
        SimpleGnome gnome1 = new SimpleGnome("Абобус");

        IApplyEffect attack = (actor, target, effect) -> {
            target.takeDamage(5 + (int) (Math.random() * (4 + Math.max(actor.getForce() - target.getForce(), 0))));
        };

        IApplyEffect do_shit = new IApplyEffect() {
            int valuable = 0;

            @Override
            public void applyEffect(Statused actor, Statused target, Status effect) {
                if  (valuable == 5){
                    System.out.println("no more");
                }
                else {
                    valuable++;
                    System.out.println("пока ничего");
                    System.out.println("но val = " + valuable);
                }
            }
        };

        Action act1 = new Action("делает грязь", (actor, target, effect) -> {
            target.setStatus(effect);
            System.out.println(actor + "сделал грязь");
            target.takeDamage(30);
        });

        Action act3 = new Action("соврешает нечто", do_shit);
        Action act2 = new Action("аттакует", attack);

        znaika.do_smth(act2, gnome1);
        System.out.println(gnome1.presentation());

        for(int i =0; i < 5; i++){
           znaika.do_smth(act3);
           gnome1.do_smth(act3);
        }
    }
}