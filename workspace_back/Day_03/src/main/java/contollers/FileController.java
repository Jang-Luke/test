package contollers;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;
import dao.FilesDAO;
import dto.FilesDTO;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Enumeration;
import java.util.List;

@WebServlet("*.file")
public class FileController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String command = request.getRequestURI();
        System.out.println(command);
        FilesDAO filesDAO = FilesDAO.getInstance();
        try {
            if (command.equals("/uploadFile.file")) {
                response.sendRedirect("/file/upload.jsp");
            } else if (command.equals("/upload.file")) {
                String realPath = request.getServletContext().getRealPath("upload");
                File realPathFile = new File(realPath);
                if (!realPathFile.exists()) {
                    realPathFile.mkdir();
                }

                MultipartRequest multipartRequest = new MultipartRequest(request, realPath, 1024 * 1024 * 10, "UTF-8", new DefaultFileRenamePolicy());

                Enumeration<String> names = multipartRequest.getFileNames();
                while (names.hasMoreElements()) {
                    String fileName = names.nextElement();
                    if (multipartRequest.getFile(fileName) != null) {
                        String originalName = multipartRequest.getOriginalFileName(fileName);
                        String systemName = multipartRequest.getFilesystemName(fileName);
                        String filePath = realPathFile.getPath();
                        filesDAO.insertFile(new FilesDTO(0, originalName, systemName, filePath, 0));
                    }
                }

                String acceptedMessage = multipartRequest.getParameter("message");

                response.sendRedirect("/");
            // 파일 전부 출력
            } else if (command.equals("/findAllFiles.file")) {
                List<FilesDTO> fileList = filesDAO.findAllFiles();
                request.setAttribute("fileList", fileList);
                request.getRequestDispatcher("/file/viewFiles.jsp").forward(request, response);
            // 파일 다운로드
            } else if (command.equals("/download.file")) {
                String uploadPath = request.getServletContext().getRealPath("upload");
                String systemName = request.getParameter("systemName");
                String originalName = request.getParameter("originalName");
                originalName = new String(originalName.getBytes("UTF-8"), "ISO-8859-1");
                response.reset();
                response.setHeader("Content-Disposition", "attachment;filename="+originalName);

                File target = new File(uploadPath + "/" + systemName);
                System.out.println(uploadPath);
                System.out.println(systemName);
                System.out.println(originalName);
                try(ServletOutputStream servletOutputStream = response.getOutputStream();
                    FileInputStream fileInputStream = new FileInputStream(target);
                    DataInputStream dataInputStream = new DataInputStream(fileInputStream);
                    FileOutputStream fileOutputStream = new FileOutputStream(target);
                    DataOutputStream dataOutputStream = new DataOutputStream(fileOutputStream);) {
                    byte[] fileContents = new byte[(int) target.length()];
                    dataInputStream.readFully(fileContents);
                    servletOutputStream.write(fileContents);
                    servletOutputStream.flush();
//                    dataOutputStream.write(fileContents);
//                    dataOutputStream.flush();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
