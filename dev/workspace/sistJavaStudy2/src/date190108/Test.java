package date190108;

public class Test {
    private static Test t;

    // 1.��ü ������ Ŭ���� ���ο����� �� �� �ֵ��� �Ѵ�.
    private Test() {

    }

    // 2. Ŭ���� �ܺο��� ��ü�� �� �� �ִ� method�� �ۼ�
    public static Test getInstance() {
        if (t == null) {
            t = new Test();
        }
        return t;
    }        
}