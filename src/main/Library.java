package main;

import java.util.ArrayList;
import java.util.List;

public class Library {
    private List<String> library;
    private int index;
    private int max;

    public Library(int num) {
        if (num < 0) {
            throw new IllegalArgumentException("음수로는 도서관을 생성할 수 없습니다.");
        }
        max = num;
        library = new ArrayList<>(num);
    }

    public void add(String name) {
        if (getTotalBookCount() >= max) {
            throw new IllegalArgumentException("도서관 최대 용량을 초과해 책을 추가할 수 없습니다.");
        } else if (checkName(name) == true) {
            throw new IllegalArgumentException("도서관에 같은 이름의 책이 존재합니다.");
        } else {
            library.add(name);
        }
    }

    public void delete(String name) {
        if (checkName(name) == true) {
            library.remove(index);
        } else {
            throw new IllegalArgumentException("도서관에 존재하지 않는 책은 삭제할 수 없습니다.");
        }
    }

    public boolean find(String name) {
        if (checkName(name) == true) {
            return true;
        }
        return false;

        // return library.contains(name);
    }

    public boolean checkName(String name) {
        boolean result = false;
        for (int i = 0; i < library.size(); i++) {
            if (library.get(i).equals(name)) {
                index = i;
                return result = true;
            } else {
                result = false;
            }
        }
        return result;
    }

    public int getTotalBookCount() {
        return library.size();
    }

    public String get(int i) {
        return library.get(i);
    }

}
