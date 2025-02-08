import java.io.*;
import java.util.*;

public class DiskAnalyzer implements Serializable {

    private long maxS = 0;

    public void run(File dir, int function) {

        switch (function) {
            case 1:
                write(containsMaxLetterS(dir));
                break;

            case 2:
                System.out.println("Укажите размер списка");
                write(filesByWeight(dir,new Scanner(System.in).nextInt()));
                break;

            case 3:
                write(averageWeight(filesByWeight(dir)));
                break;

            case 4:
                write(countValues(filesByFirstLetter(dir)));
                break;

            default:
                System.out.println("Неверная команда");
        }
    }

    public Collection<? extends String> containsMaxLetterS(File dir) {

        ArrayList<String> list = new ArrayList<>();

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        list.addAll(containsMaxLetterS(file));
                    } else {
                        String fileName = file.getName().toLowerCase();

                        if (fileName.contains("s")) {
                            long currentCount = fileName.chars()
                                    .filter(ch -> ch == 's')
                                    .count();

                            if (currentCount > maxS) {
                                maxS = currentCount;
                                list = new ArrayList<>();
                            }

                            if (currentCount == maxS) {
                                list.add(file.toPath().toString());
                            }
                        }
                    }
                }
            }
        }
        return list;
    }

    // 2.	Top-5 файлов с самым большим размером

    public HashMap<Long, String> filesByWeight(File dir, int mapSize) {

        HashMap<Long, String> map = new HashMap<>();

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        map.putAll(filesByWeight(file));
                    } else {
                        map.put(file.length(), file.getName());
                    }
                }
            }
        }
        return getSortedMapWithFixedSize(map,mapSize);
    }

    public HashMap<Long, String> filesByWeight(File dir) {

        HashMap<Long, String> map = new HashMap<>();

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        map.putAll(filesByWeight(file));
                    } else {
                        map.put(file.length(), file.getName());
                    }
                }
            }
        }
        return map;
    }

    public HashMap<Long, String> getSortedMapWithFixedSize(HashMap<Long, String> map, int mapSize) {
        TreeMap<Long, String> sortedMap = new TreeMap<>(Comparator.reverseOrder());
        HashMap<Long, String> topFiles = new HashMap<>();

        sortedMap.putAll(map);

        sortedMap.entrySet().stream()
                .limit(mapSize)
                .forEach(itm -> topFiles.put(itm.getKey(), itm.getValue()));

        return topFiles;
    }

    // 	3.  Средний размер файла в указанной директории или любой ее поддиректории

    public long averageWeight(HashMap<Long, String> map) {
        long sum = 0;

        for (Long key : map.keySet()) {
            sum += key;
        }

        return sum / map.size();
    }

    //  4.	Количество файлов и папок разбитое по первым буквам алфавита (например на букву A – начинается 100 000 файлов и 200 папок)

    public HashMap<String,List<String>> filesByFirstLetter(File dir) {

        HashMap<String, List<String>> mapFiles = new HashMap<>();

        if (dir.isDirectory()) {
            File[] files = dir.listFiles();

            if (files != null) {
                for (File file : files) {
                    if (file.isDirectory()) {
                        String key = file.getName().charAt(0) + "-d";
                        mapFiles.computeIfAbsent(key, k -> new ArrayList<>()).add(file.getName());

                        mapFiles.putAll(filesByFirstLetter(file));
                    } else {
                        String key = String.valueOf(file.getName().charAt(0));
                        mapFiles.computeIfAbsent(key, k -> new ArrayList<>()).add(file.getName());
                    }
                }
            }
        }
        return mapFiles;
    }

    public List<String> countValues(HashMap<String, List<String>> map) {
        System.out.println("Введите символ:");
        return map.get(new Scanner(System.in).nextLine());
    }

    public static void write(Object result) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("DiskAnalyzerResult.txt"))) {

            oos.writeObject(result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void read(String path) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(path))) {

            Object result = ois.readObject();

            System.out.println("Информация в файле - " + result);

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}