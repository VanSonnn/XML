import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class b1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhap duong dan file: ");
        String filePath = sc.nextLine();

        File directory = new File(filePath);

        if (!directory.exists() || !directory.isDirectory()) {
            System.out.println("thu muc khong ton tai.");
            return;
        }

        try {
            FileWriter writer = new FileWriter("bai1.xml");
            writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
            writer.write("<BAITAP>\n");

            traverseDirectory(directory, writer);

            writer.write("</BAITAP>");
            writer.close();

            System.out.println("Da tao file xml thanh cong.");

        } catch (IOException e) {
            System.out.println("Loi khi tao tep XML: " + e.getMessage());
        }
    }

    private static void traverseDirectory(File directory, FileWriter writer) throws IOException {
        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                
                if (file.isDirectory()) {
                    writer.write("\t" + "<" + file.getName() + ">\n");
                    writer.write("\t" + "</" + file.getName() + ">\n");
                } else {
                    writer.write("\t" + "<file>" + file.getName() + "</file>\n");
                }
            }
        }
    }
    
}
