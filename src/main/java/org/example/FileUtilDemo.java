package org.example;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.file.FileReader;
import cn.hutool.core.io.file.FileWriter;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class FileUtilDemo {
    public static void main(String[] args) {
        // 演示目录：target/hutool-demo
        File baseDir = FileUtil.mkdir("target/hutool-demo");
        File file = FileUtil.file(baseDir, "hello.txt");

        // 写文件
        FileWriter writer = FileWriter.create(file, StandardCharsets.UTF_8);
        writer.write("你好，Hutool FileUtil!\nLine2");

        // 读文件
        FileReader reader = FileReader.create(file, StandardCharsets.UTF_8);
        String content = reader.readString();
        System.out.println("content:\n" + content);

        // 复制与扩展名
        File copy = FileUtil.file(baseDir, "hello_copy.txt");
        FileUtil.copy(file, copy, true);
        System.out.println("extName: " + FileUtil.extName(copy));

        // 遍历目录
        List<File> files = FileUtil.loopFiles(baseDir);
        System.out.println("files: " + files);

        // 文件大小
        System.out.println("size(byte): " + FileUtil.size(file));

        // 清理演示文件（保留目录）
        FileUtil.del(file);
        FileUtil.del(copy);
    }
}


