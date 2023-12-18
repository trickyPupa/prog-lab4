package technical;

public class DefaultEffect implements IApplyEffect {
    @Override
    public void applyEffect(Statused actor, Statused target, Status effect) {
        target.setStatus(effect);
    }
}
