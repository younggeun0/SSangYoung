package date190108;

public class Test {
    private static Test t;

    // 1.객체 생성을 클래스 내부에서만 할 수 있도록 한다.
    private Test() {

    }

    // 2. 클래스 외부에서 객체를 얻어갈 수 있는 method를 작성
    public static Test getInstance() {
        if (t == null) {
            t = new Test();
        }
        return t;
    }        
}