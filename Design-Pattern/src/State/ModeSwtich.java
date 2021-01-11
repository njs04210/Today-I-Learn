package State;

public class ModeSwtich {
    private ModeState modeState = new ModeStateLight(); //modeState가 Light모드로 초기화

    public void setState(ModeState modeState) { //modeState 정하는 함수
        this.modeState = modeState;
    }

    public void onSwitch() {
        modeState.toggle(this);
    }
}
