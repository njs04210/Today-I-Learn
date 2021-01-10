public interface ModeState {
    public void toggle (ModeSwtich modeSwtich);
}

class ModeStateLight implements ModeState { //Light모드
    @Override
    public void toggle(ModeSwtich modeSwtich) {
        System.out.println("FROM LIGHT TO DARK");
        /**
         * 화면 어둡게 하는 코드
         */
        modeSwtich.setState(new ModeStateDark());
    }
}

class ModeStateDark implements ModeState { //Dark모드
    @Override
    public void toggle(ModeSwtich modeSwtich) {
        System.out.println("FROM DARK TO LIGHT");
        /**
         * 화면 밝게 하는 코드
         */
        modeSwtich.setState(new ModeStateLight());
    }
}
