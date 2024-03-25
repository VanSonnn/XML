import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class bai2 {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
       
        System.out.println("Nhập số sinh viên cần thêm:");
        int n = sc.nextInt();
        sc.nextLine(); 
        
        String indent = ""; 
        for (int i = 0; i < n; i++) {
            System.out.println(indent + "Nhập thông tin cho sinh viên " + (i + 1) + ":");
            System.out.println(indent + "Tên:");
            String name = sc.nextLine();
            System.out.println(indent + "Tuổi:");
            int age = sc.nextInt();
            System.out.println(indent + "GPA:");
            double gpa = sc.nextDouble();
            sc.nextLine(); // Consume newline
            studentList.add(new Student(name, age, gpa));
        }
        
        try (PrintWriter writer = new PrintWriter("bai2.xml", "UTF-8")) {
            writer.println("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            writer.println("<students>");
            indent += "\t"; 
            for (Student student : studentList) {
                writer.println(indent + "<student>");
                indent += "\t";
                writer.println(indent + "<name>" + student.name + "</name>");
                writer.println(indent + "<age>" + student.age + "</age>");
                writer.println(indent + "<gpa>" + student.gpa + "</gpa>");
                indent = indent.substring(1); 
                writer.println(indent + "</student>");
            }
            indent = indent.substring(1); 
            writer.println(indent + "</students>");
            System.out.println("Tạo tệp XML 'bai2.xml' thành công.");
        } catch (Exception e) {
            System.out.println("Lỗi khi tạo tệp XML: " + e.getMessage());
        }
    }
}
