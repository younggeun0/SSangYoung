package date181121;

public class TestWhile01 {
    public static void main(String[] args) {

        // ���� �Է¹޾� 2~9�� ���̶�� ��������  ���
        int input = Integer.parseInt(args[0]);    // ��
        if (input>1 && input<10) {
            
            System.out.println(input + "��  ����ϰڽ��ϴ�.");
            
            int i = 1;          // �ʱ��
            while (i < 10) {    // ���ǽ�
                System.out.println(input+" *  "+i+" = "+(input*i));
                
                i++;            // ������
            }
                
        } else {
            System.out.println("���� 2~9 ����  ���� �Է°����մϴ�.");
        }
    }
}