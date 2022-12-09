import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {
    private static int part1(Map<String, Integer> sizes) {
        return sizes.values().stream()
                .mapToInt(x -> x)
                .filter(x -> x <= 100_000)
                .sum();
    }

    private static int part2(Map<String, Integer> sizes) {
        int total = 70_000_000;
        int needed = 30_000_000;
        int used = sizes.get("/");
        return sizes.values().stream().mapToInt(x -> x)
                .filter(wouldBeFreed -> (total - used + wouldBeFreed) > needed)
                .min()
                .orElseThrow(NoSuchElementException::new);
    }

    private static Map<String, Integer> getDirectorySizes(File file) throws IOException {
        Map<String, Integer> directorySizes = new HashMap<>();
        Deque<String> directoryStack = new ArrayDeque<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while (null != (line = reader.readLine())) {
                if (line.charAt(0) == '$') {
                    String command = line.substring(2);
                    if (command.startsWith("cd ")) {
                        String dir = command.substring(3);
                        if ("..".equals(dir)) {
                            directoryStack.pop();
                        } else if ("/".equals(dir)) {
                            directoryStack.clear();
                            directoryStack.push("/");
                        } else {
                            directoryStack.push(directoryStack.peek() + "/" + dir);
                        }
                        directorySizes.putIfAbsent(directoryStack.peek(), 0);
                    } else if (command.startsWith("ls")) {

                    } else {
                        throw new IllegalArgumentException("Unknown command in line: " + command);
                    }
                } else {
                    String field1 = line.substring(0, line.indexOf(' '));
                    if (!"dir".equals(field1)) {
                        int size = Integer.parseInt(field1);
                        Deque<String> copy = new ArrayDeque<>(directoryStack);
                        while (!copy.isEmpty()) {
                            directorySizes.compute(copy.pop(), (ignore, oldSize) -> oldSize + size);
                        }
                    }
                }
            }
        }
        return directorySizes;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("input7.txt");
        System.out.println(part1(getDirectorySizes(file)));
        System.out.println(part2(getDirectorySizes(file)));
    }
}

