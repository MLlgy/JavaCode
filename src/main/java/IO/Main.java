package IO;

import java.io.*;

public class Main {

    private static String allPath = "/Users/liguoying/Documents/io";


    public static void main(String[] args) {
//        getFile();
//        test2();
//        test3();
//        test4();
//        outputStream();
        //            copyFile();
//        copyDic();
//        testReader();
        testWriter();
        bufferendByte();
//        testTransalte();
    }

    private static void testTransalte() throws FileNotFoundException, UnsupportedEncodingException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(""),"UTF-8"));

        Reader fileReader = new InputStreamReader(new FileInputStream(""),"UTF-8");
//        BufferedReader bufferedReader = new BufferedReader(new FileReader(""));
    }

    private static void bufferendByte() {

    }

    /**
     * Writer
     */
    private static void testWriter() {
        File src = new File(allPath, "b");
        Writer writer = null;
        if (!src.exists()) {
            src.delete();
        }
        try {
            writer = new FileWriter(src, true);
            String str = "我们都是一个好孩子\n";
            writer.append(str);
            writer.append("希望有个好的未来。");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                writer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Reader
     */
    private static void testReader() {
        File src = new File(allPath, "a");
        Reader reader = null;
        if (src.exists()) {
            try {
                reader = new FileReader(src);
                char[] buffer = new char[512];
                int len = 0;
                while ((len = reader.read(buffer)) != -1) {
                    String str = new String(buffer, 0, len);
                    System.out.println(str);
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
                System.out.println("file not exist");
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    /**
     * 拷贝文件夹
     */
    public static void copyDic() {
        String src = allPath + File.separator + "name";
        String dest = allPath + File.separator + "dic";
        File srcFile = new File(src);
        File desFile = null;
        System.out.println(srcFile.isDirectory());
        if (srcFile.isDirectory()) {
            System.out.println("dfdf");
            desFile = new File(dest, srcFile.getName());

        }
        doCopyDic(srcFile, desFile);
    }

    private static void doCopyDic(File srcFile, File desFile) {
        if (srcFile.isFile()) {
            try {
                copyFileWithFile(srcFile, desFile);
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else if (srcFile.isDirectory()) {
            desFile.mkdirs();
            for (File sub : srcFile.listFiles()) {
                doCopyDic(sub, new File(desFile, sub.getName()));
            }
        }


    }

    private static void copyFile() throws IOException {
        copyFile2(allPath + File.separator + "a", allPath + File.separator + "abc");

    }

    public static void copyFile2(String srcFileStr, String desFileStr) throws IOException {
        // 1. 建立程序与文件之间的联系()
        File srcFile = new File(srcFileStr);
        File desFile = new File(desFileStr);
        copyFileWithFile(srcFile, desFile);
    }

    public static void copyFileWithFile(File src, File dest) throws IOException {
        // 1. 建立程序与文件之间的联系()
        if (!src.isFile()) {
//            return;
            throw new IOException("不能 copy dic");
        }
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        if (!dest.exists()) {
            try {
                dest.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        inputStream = new FileInputStream(src);
        outputStream = new FileOutputStream(dest);

        byte[] flush = new byte[1024];
        int len = 0;
        while ((len = inputStream.read(flush)) != -1) {
            outputStream.write(flush, 0, len);
        }
        outputStream.flush();

        outputStream.close();
        inputStream.close();
    }

    /**
     * 字节流 -- 文件写出
     */
    private static void outputStream() {
    File file = new File(allPath, "a");
    FileOutputStream outputStream = null;
    try {
        outputStream = new FileOutputStream(file, true);
        String inrfo = "wojwoo我们";
        byte[] data = inrfo.getBytes();
        outputStream.write(data);
        outputStream.flush();//强制刷新，使在数组中的数据强制写出

    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    }

    /**
     * 字节流 -- 读取文件
     */
    private static void test4() {
        File file = new File(allPath, "a");
        FileInputStream inputStream = null;
        System.out.println(file.exists());
        if (file.exists()) {
            try {
                inputStream = new FileInputStream(file);
                // 缓存数组
                byte[] array = new byte[10];
                int len = 0;//实际读取的大小
                while ((len = inputStream.read(array)) != -1) {
                    String info = new String(array, 0, len);
                    System.out.println(info);
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (inputStream != null) {
                    try {
                        inputStream.close();
                    } catch (IOException e) {

                    }
                }
            }
        }
    }

    private static void test3() {
        File parentFile = new File(allPath);
        File dic = new File(parentFile, "testDictory");
        dic.mkdir();
        File dics = new File(parentFile, "name/dic");
        File dics1 = new File(parentFile, "name/ji");
        dics1.mkdirs();

        if (dics1.isDirectory() && dics1.exists()) {
        }
    }

    private static void getFile() {
        System.out.println(File.pathSeparator);
        System.out.println(File.separator);
        String path = "/Users/liguoying/Documents/io/a";
        File file = new File(path);
        System.out.println(file.getName());
        System.out.println(file.getPath());
        file = new File(new File("/Users/liguoying/Documents/io"), "a");
        System.out.println(file.getName());
        System.out.println(file.getPath());
        System.out.println(file.getAbsoluteFile());
        System.out.println(file.getParentFile());
        file = new File("q");
        System.out.println(file.getParent());
    }

    /**
     * 创建文件和删除文件
     */
    private static void test2() {
        String path = "/Users/liguoying/Documents/io/b";
        File file = new File(path);
        System.out.println(file.exists());
        if (!file.exists()) {
            try {
                boolean flag = file.createNewFile();
                System.out.println(flag);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println(file.delete());

        try {
            File temp = File.createTempFile("test", ".tmp", new File(allPath));
            Thread.sleep(3000);
            temp.deleteOnExit();// 退出后删除文件
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
