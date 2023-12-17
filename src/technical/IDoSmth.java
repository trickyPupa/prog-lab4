package technical;

import technical.exceptions.StoryException;

public interface IDoSmth {
    boolean do_smth(Action action);

    default boolean do_smth(Action action, boolean storyImportant) throws StoryException{
        boolean flag = do_smth(action);
        if (storyImportant && !flag){
            throw new StoryException();
        }
        return flag;
    }

    boolean do_smth(Action action, Statused target);

    default boolean do_smth(Action action, Statused target, boolean storyImportant) throws StoryException{
        boolean flag = do_smth(action, target);
        if (storyImportant && !flag){
            throw new StoryException();
        }
        return flag;
    }

    default void simple_action(String label) {
        Action simple_act = new Action(label);
        do_smth(simple_act);
    }

}
