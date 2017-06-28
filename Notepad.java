import java.awt.FileDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
class notep{
JFrame fr;
JTextArea a;
JMenuBar mb;
JMenu File,Edit,Format,View,Help;
JMenuItem New,Exit,Open,Save,Cut,Copy,Paste,Print,Delete;
FileDialog d,op;

       notep() {
fr=new JFrame("NotePad");
d=new FileDialog(fr,"Save",FileDialog.SAVE);
op=new FileDialog(fr,"Save",FileDialog.LOAD);
a=new JTextArea();

File=new JMenu("File");
Edit=new JMenu("Edit");
Format=new JMenu("Format");
View=new JMenu("View");
Help=new JMenu("Help");

New=new JMenuItem("New");
Exit=new JMenuItem("Exit");
Open=new JMenuItem("Open");
Save=new JMenuItem("Save");
Print=new JMenuItem("Print");
Cut=new JMenuItem("Cut");
Copy=new JMenuItem("Copy");
Paste=new JMenuItem("Paste");
Delete=new JMenuItem("Delete");

mb=new JMenuBar();

File.add(New);
File.add(Open);
File.add(Save);
File.add(Print);
File.add(Exit);

Edit.add(Cut);
Edit.add(Copy);
Edit.add(Paste);
Edit.add(Delete);

mb.add(File);
mb.add(Edit);
mb.add(Format);
mb.add(View);
mb.add(Help);

fr.setJMenuBar(mb);
Cut.setEnabled(false);
Copy.setEnabled(false);
Paste.setEnabled(false);
Save.setEnabled(false);
Delete.setEnabled(false);
Print.setEnabled(false);

New.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

fr.add(a);
fr.setTitle("Untitled-NotePad");
fr.setVisible(true);
Save.setEnabled(true);
Cut.setEnabled(true);
Copy.setEnabled(true);
Paste.setEnabled(true);
Delete.setEnabled(true);
Print.setEnabled(true);
}

});

Exit.addActionListener(new ActionListener() {

public void actionPerformed(ActionEvent arg0) {

fr.dispose();
}

});

Cut.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

try {
a.print();
} catch (PrinterException e) {
// TODO Auto-generated catch block
e.printStackTrace();
}
}

});

Cut.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

a.cut();
}

});
Copy.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
a.copy();
}

});
Paste.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {

a.paste();
}

});
Delete.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
a.replaceSelection("");
}

});
Save.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
String data=a.getText();
d.setVisible(true);
File f =new File(d.getDirectory(),d.getFile());
FileOutputStream r=null;
try {

r=new FileOutputStream(f,true);
char a[]=data.toCharArray();
int i=0;
while(i<a.length){
r.write((int)a[i]);
i++;
}
r.close();
                                       fr.setTitle(d.getFile()+" Notepad");
} catch (Exception e) {

e.printStackTrace();
}
}

});
Open.addActionListener(new ActionListener() {
public void actionPerformed(ActionEvent arg0) {
op.setVisible(true);
File f =new File(op.getDirectory(),op.getFile());
FileInputStream in=null;
try {
in=new FileInputStream(f);
int ch=0;
StringBuffer line=new StringBuffer();
while((ch=in.read())!=-1) {
line.append((char)ch+"");
}
a.setText(line.toString());
fr.add(a);
fr.setTitle(op.getFile()+" Notepad");
fr.setVisible(true);
in.close();
}catch(Exception e ){

}
}

});

fr.pack();
fr.setSize(300,300);
fr.setVisible(true);
}
}
public class Notepad {
public static void main(String[] args) {
new notep();
}
}
