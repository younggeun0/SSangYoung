package kr.co.sist.multichat.client.view;

import javax.swing.JDialog;
import javax.swing.DefaultListModel;
import javax.swing.JColorChooser;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;

@SuppressWarnings("serial")
public class ClientSelectUserView extends JDialog {

   private JDialog jd;
   private JList<String> jlstName;
   private DefaultListModel<String> dlm;
   private JScrollPane jspUser;
   
   public ClientSelectUserView(ClientChatView ccv) {
      super(ccv,"立加磊 格废", true);
      
      dlm=new DefaultListModel<String>();
      jlstName=new JList<String>(dlm);
      jspUser=new JScrollPane(jlstName);
            
      jlstName.setBorder(new TitledBorder("立加磊 格废"));
      
      add("Center", jspUser);
      
      setBounds(ccv.getX()+485, ccv.getY()+0, 300, 400);
      setVisible(true);
      
      setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
   }//useJDialog

}//main