package test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import main.Library;

public class LibraryTest {
    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library(3);
    }

    @Test
    @DisplayName("이름 찾기 성공")
    void checkNameTest() {
        library.add("a");
        library.add("b");

        assertEquals(library.checkName("a"), true);
    }

    @Test
    @DisplayName("음수 도서관 생성 시")
    void negativeLibrary_throwIllegalArgumentException() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> new Library(-1));
        assertEquals(exception.getMessage(), "음수로는 도서관을 생성할 수 없습니다.");
    }

    @Test
    @DisplayName("Delete ")
    void deleteTest() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> library.delete("a"));
        assertEquals(exception.getMessage(), "도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
    }

    @ParameterizedTest
    @ValueSource(strings = { "어린왕자", "엄지공주" })
    void find(String name) {
        Library library = new Library(5);
        library.add(name);
    }

    @RepeatedTest(value = 10)
    void repeat() {
        System.out.println("def");
    }

}
