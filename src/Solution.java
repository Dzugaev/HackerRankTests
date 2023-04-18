import java.io.*;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) throws IOException {


//        int [] arr = {1,1,2,2,6};
        System.out.println(lengthOfLastWord58("arfadafasd lol"));


    }

    /**livecode test*/

    /**
     * "class User{
     * LocalDate birthDate;
     * String fio;
     * }
     * <p>
     * Необходимо написать функцию public … groupUsersByBirthDate(List<User> user), которая будет
     * группировать пользователей по датам их рождения(полю birthDate).
     * Вместо троеточия указать и обосновать оптимальный тип данных, который должен возвращать метод."
     * <p>
     * User user1 = new User(LocalDate.now(), "A");
     * User user2 = new User(LocalDate.MAX, "B");
     * User user3 = new User(LocalDate.MAX, "C");
     * <p>
     * HashMap<LocalDate, ArrayList<User>> output = groupUsersByBirthDate(Arrays.asList(user1, user2, user3));
     * System.out.println(output);
     */
    static class User {
        LocalDate birthDate;
        String fio;

        public User(LocalDate birthDate, String fio) {
            this.birthDate = birthDate;
            this.fio = fio;
        }

        @Override
        public String toString() {
            return fio;
        }
    }

    public static HashMap<LocalDate, ArrayList<User>> groupUsersByBirthDate(List<User> users) {
        HashMap<LocalDate, ArrayList<User>> groupedUsers = new HashMap<>();

        for (User user : users) {
            if (groupedUsers.containsKey(user.birthDate)) {
                ArrayList<User> tmp = groupedUsers.get(user.birthDate);
                tmp.add(user);
                groupedUsers.put(user.birthDate, tmp);
            } else {
                groupedUsers.put(user.birthDate, new ArrayList<>(Arrays.asList(user)));
            }
        }

        return groupedUsers;
    }

    /**
     * ----------LEETCODE--------------
     */

    public static int lengthOfLastWord58(String s) {
        String [] words = s.split(" ");
        String [] word = words[words.length-1].split(" ");
        return word.length-1;
    }

    public static String longestPalindrome5(String s) {
        String output = "";
        ArrayList<String> letters = new ArrayList<>(Arrays.asList(s.split("")));



        for (int i = 0; i < s.length(); i++) {
            String first = letters.get(i);

        }

        return output;
    }

    private static void process() {

    }

    public static int searchInsert35(int[] nums, int target) {

        /**solution with stream api*/
//        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
//        if(list.contains(target)){
//            return list.indexOf(target);
//        }else {
//            Optional<Integer> first = list.stream().filter(x -> x > target).findFirst();
//            if(first.isEmpty()){
//                return nums.length;
//            }else {
//                return list.indexOf(first.get());
//            }
//        }
        ArrayList<Integer> list = (ArrayList<Integer>) Arrays.stream(nums).boxed().collect(Collectors.toList());
        if (list.contains(target)) {
            return list.indexOf(target);
        } else {
            int start = 0;
            int end = nums.length - 1;
            while (true) {
                if (list.get((end - start) / 2) > target) {
                    end = end / 2;
                } else {
                    start = end / 2;
                }
            }
        }

    }

    // unfineshed
    public static int divide(int dividend, int divisor) {
        int times = -1;
        int sum = 0;

        if (divisor == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        boolean isNegative = ((dividend < 0 || divisor < 0) && !(dividend < 0 && divisor < 0));
        long longDividend = Math.abs((long) dividend);
        long longDivisor = Math.abs((long) divisor);
        while (longDividend >= sum) {
            sum += longDivisor;
            times++;
        }

        return isNegative ? times * -1 : times;
    }

    // unfineshed
    public static int removeDuplicates(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size();
    }

    public static boolean isValid(String s) {

        Stack<Integer> last = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            switch (String.valueOf(s.charAt(i))) {
                case ("("): {
                    last.add(1);
                    continue;
                }
                case ("{"): {
                    last.add(2);
                    continue;
                }
                case ("["): {
                    last.add(3);
                    continue;
                }
                case (")"): {
                    if (last.isEmpty() || last.pop() != 1) return false;
                    continue;
                }
                case ("}"): {
                    if (last.isEmpty() || last.pop() != 2) return false;
                    continue;
                }
                case ("]"): {
                    if (last.isEmpty() || last.pop() != 3) return false;
                }
            }
        }
        if (!last.isEmpty()) return false;
        else return true;
    }

    // unfineshed
    public static List<String> letterCombinations(String digits) {
        HashMap<String, String[]> dict = new HashMap<>();
        dict.put("2", new String[]{"a", "b", "c"});
        dict.put("3", new String[]{"d", "e", "f"});
        dict.put("4", new String[]{"g", "h", "i"});
        dict.put("5", new String[]{"j", "k", "l"});
        dict.put("6", new String[]{"m", "n", "o"});
        dict.put("7", new String[]{"p", "q", "r", "s"});
        dict.put("8", new String[]{"t", "u", "v"});
        dict.put("9", new String[]{"w", "x", "y", "z"});


        for (int i = 0; i < digits.length(); i++) {
            String.valueOf(digits.charAt(i));
        }
        return null;
    }

    public static String longestCommonPrefix(String[] strs) {
        String output = "";
        if (strs.length == 0) return output;

        String prefix = "";
        int i = 0;
        int letter = 0;
        while (true) {
            if (strs.length > i) {
                try {
                    if (String.valueOf(strs[i].charAt(letter)).equals(prefix) || prefix.equals("")) {

                        if (prefix.equals("")) {
                            if (strs[i].length() == 0) return output;
                            prefix = String.valueOf(strs[i].charAt(letter));
                            continue;
                        }
                        if (strs.length - 1 != i) {
                            i++;
                        } else {
                            i = 0;
                            output += prefix;
                            prefix = "";
                            letter++;
                        }
                    } else break;
                } catch (Exception e) {
                    break;
                }
            } else break;
        }
        return output;
    }

    // unfineshed
    public static int maxArea(int[] height) {

        int output = 0;

        for (int i = 0; i < height.length - 1; i++) {
            for (int j = 1; j < height.length; j++) {
                if (height[i] < height[j])
                    output = Math.max((height[i] * (j - i)), output);
                else
                    output = Math.max((height[j] * (j - i)), output);
            }
        }

        return output;
    }

    public static boolean isPalindrome(int x) {
        if (x < 0) return false;
        String s = Integer.toString(x);
        String nums[] = s.split("");

        int j = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            if (i == j) return true;
            else {
                if (nums[i].equals(nums[j])) {
                    j--;
                } else return false;
            }
        }

        return true;
    }

    public static int reverse(int x) {
        long output = 0;

        while (true) {
            if ((x % 10 != 0) || (x / 10 != 0)) {
                int a = x % 10;
                output = (output + a) * 10;
                x = x / 10;
            } else break;
        }
        output = output / 10;
        if (Math.abs(output) > 2147483648l)
            return 0;
        return (int) output;
    }

    public static int lengthOfLongestSubstring(String s) {

        int count = 0;
        int max = 0;
        HashMap<String, Integer> dictionary = new HashMap<>();

        if (s.equals("")) {
            return 0;
        }
        String[] letters = s.split("");

        for (int i = 0; i < letters.length; i++) {
            if (dictionary.get(letters[i]) == null) {
                count++;
                dictionary.put(letters[i], i);
            } else {
                max = max > count ? max : count;

                i = dictionary.get(letters[i]);

                dictionary.clear();
                count = 0;

            }
        }
        max = max > count ? max : count;

        return max;
    }

    public static int[] twoSum(int[] nums, int target) {

        Integer[] arr = Arrays.stream(nums).boxed().toArray(Integer[]::new);
        ArrayList<Integer> list = new ArrayList<Integer>(Arrays.asList(arr));
        int[] output = new int[1];

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < list.size(); i++) {
            //map.put(i, target - list.get(i));

            if (list.contains(target - list.get(i))) {
                int a = target - list.get(i);
                if (i != list.indexOf(a)) {
                    output = new int[]{i, list.indexOf(a)};
                }
            }
        }


        return output;
    }


    /**
     * -------------hacker rang------------------
     */
    public static void regEx2() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        ArrayList<String> outs = new ArrayList<>(count);

        while (count > 0) {
            count--;
            final String regex = "\\b(\\w+)\\b\\s*(?=.*\\b\\1\\b)";
            final String input = reader.readLine();

            final String result = input.replaceAll(regex, "");
            outs.add(result);
        }

        outs.forEach(System.out::println);

    }

    public static void regEx() throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String s = reader.readLine();

        String IPADDRESS_PATTERN =
                "(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)";

        Pattern pattern = Pattern.compile(IPADDRESS_PATTERN);
//        Matcher matcher = pattern.matcher(ipString);
//        if (matcher.find()) {
//            return matcher.group();
//        } else{
//            return "0.0.0.0";
    }


    public static void bigDecimal() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());

        ArrayList<String> strings = new ArrayList<>();
        ArrayList<Double> doubles = new ArrayList<>();

        while (count > 0) {
            count--;
            String s = reader.readLine();
            strings.add(s);
            doubles.add(Double.parseDouble(s));
        } //filling

        doubles.sort(Comparator.reverseOrder()); //sorting

        HashMap<Double, Integer> map = new HashMap<>();
        doubles.forEach(d -> {
            if (map.containsKey(d)) map.put(d, map.get(d) + 1);
            else map.put(d, 1);

        });

        //writing
        ArrayList<String> output = new ArrayList<>();
        doubles.forEach(sortDouble -> {
            int id = -1;
            int clonesCount = map.get(sortDouble);
            for (int j = strings.size() - 1; j >= 0; j--) {
                String currentString = strings.get(j);
                double currentDouble = Double.parseDouble(currentString);

                if (sortDouble == currentDouble) {
                    if (clonesCount == 1) {
                        id = j;
                        map.put(sortDouble, map.get(sortDouble) - 1);
                        clonesCount--;
                    } else {
                        clonesCount--;
                    }
                }

            }

            output.add(strings.get(id));
        });

        output.forEach(System.out::println);
    }


    public static void lambda() throws IOException {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = 0;
        try {
            count = Integer.parseInt(reader.readLine());
        } catch (Exception e) {
            e.printStackTrace();
        }
        ArrayList<String> inputs = new ArrayList<>(count);
        ArrayList<String> outputs = new ArrayList<>(count);

        while (count > 0) {
            inputs.add(reader.readLine());
            count--;
        }

        inputs.forEach(string -> {
            String[] strings = string.split(" ");
            int operation = Integer.parseInt(strings[0]);
            Integer num = Integer.parseInt(strings[1]);
            switch (operation) {
                case 1: {
                    outputs.add((num % 2 == 0)
                            ? "EVEN"
                            : "ODD");
                    break;
                }
                case 2: {
                    boolean prime = true;
                    for (int p = 2; p < num; p++) {
                        if (num % p == 0) {
                            prime = false;
                            break;
                        }
                    }
                    outputs.add((prime)
                            ? "PRIME"
                            : "COMPOSITE");
                    break;
                }
                case 3: {
                    String intStr = String.valueOf(num);
                    outputs.add((intStr.equals(new StringBuilder(intStr).reverse().toString()))
                            ? "PALINDROME"
                            : "NOT PALINDROME");
                    break;
                }
            }
        });

        outputs.forEach(System.out::println);
    }


}