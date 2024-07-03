package org.example;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    // 用于捕获 System.out 输出的流
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    // 保存原始的 System.out
    private final PrintStream originalOut = System.out;

    @BeforeEach
    public void setUpStreams() {
        // 将 System.out 重定向到捕获流
        System.setOut(new PrintStream(outContent));
    }

    @AfterEach
    public void restoreStreams() {
        // 恢复原始的 System.out
        System.setOut(originalOut);
    }

    @Test
    public void testMainOutput() {
        // 调用被测试的方法
        Main.main(new String[0]);

        // 断言捕获的输出是否与预期一致
        assertEquals("Hello world" + System.lineSeparator(), outContent.toString());
    }
}

