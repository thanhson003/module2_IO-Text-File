import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class FileCopy {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập đường dẫn tập tin nguồn (source file): ");
        String sourcePath = scanner.nextLine();
        File sourceFile = new File(sourcePath);

        if (!sourceFile.exists() || !sourceFile.isFile()) {
            System.err.println("Cảnh báo: Tập tin nguồn không tồn tại hoặc không hợp lệ!");
            return;
        }

        System.out.print("Nhập đường dẫn tập tin đích (target file): ");
        String targetPath = scanner.nextLine();
        File targetFile = new File(targetPath);

        if (targetFile.exists()) {
            System.err.println("Cảnh báo: Tập tin đích đã tồn tại!");
            return;
        }

        try (InputStream inStream = new FileInputStream(sourceFile);
             OutputStream outStream = new FileOutputStream(targetFile)) {

            int byteRead;
            int byteCount = 0;

            while ((byteRead = inStream.read()) != -1) {
                outStream.write(byteRead);
                byteCount++;
            }
            System.out.println("Đã sao chép tập tin thành công!");
            System.out.println("Số byte (ký tự) trong tệp là: " + byteCount);

        } catch (IOException e) {
            System.err.println("Đã xảy ra lỗi trong quá trình đọc/ghi tập tin: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}