package date181121;

public class UseInstanceVariable {
    
    int i;      // ������ �ʱ�ȭ�� 0
    int j;
    double d;   // �Ǽ��� �ʱ�ȭ�� 0.0
    char c;     // ������ �ʱ�ȭ�� \u0000
    boolean b;  // ����   �ʱ�ȭ�� false
    String str; // ������ �ʱ�ȭ�� null
    UseInstanceVariable someClass;
    
    public static void main(String[] args) {
        // static ������ ���� ���� �޸�(method ����)�� �ε��
        // ���������� �𸣴� instance ������ ���� ����� �� ����.
        // ��üȭ�� �ϸ� ��ü�� �޸�(heap)�� �����ǰ�,
        // �� �ּҸ� �޸�(stack)�� ����
        UseInstanceVariable uiv1 = new  UseInstanceVariable();
        UseInstanceVariable uiv2 = new  UseInstanceVariable();
        
        System.out.println("��ü���(heap�ּ�):"+uiv1);
        System.out.println("��ü���(heap�ּ�):"+uiv2);
        
        // heap�� ������ instance variable�� ���
        uiv1.i=11;
        uiv1.j=21;
        
        System.out.println("uiv1��ü�� �������  i="+uiv1.i);
        System.out.println("uiv1��ü��  �ν��Ͻ����� j="+uiv1.j);
        
        // instance(member)������ �ڵ��ʱ�ȭ��
        System.out.println("============ �ڵ�  �ʱ�ȭ�� ===========");
        System.out.println("������ :"+uiv2.i);
        System.out.println("�Ǽ��� :"+uiv2.d);
        System.out.println("������ :"+uiv2.c); // white space ���
        System.out.println("���� :"+uiv2.b);
        System.out.println("������-String  :"+uiv2.str);
        System.out.println("������-class  :"+uiv2.someClass);
    }
}
