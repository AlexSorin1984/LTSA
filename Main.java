import java.util.*;

public class Main {
    public static void main(String[] args) {

        String[] words = {"abc","deq","mee","aqq","dkd","ccc"};
        String pattern = "abb";

        List<String> result = findAndReplacePattern(words, pattern);
        System.out.println(result.toString());

    }


    public static List<String> findAndReplacePattern(String[] words, String pattern) {
        List<String> ans = new ArrayList<>();

        for (String s : words) {
            if (isMatching(s, pattern)) {
                ans.add(s);
            }
        }

        return ans;
    }

    public static boolean isMatching(String s, String t) {
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Boolean> map2 = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char fromString = s.charAt(i);
            char fromPattern = t.charAt(i);

            if (map1.containsKey(fromString)) {
                if (map1.get(fromString) != fromPattern) return false;
            }

            else {
                if (map2.containsKey(fromPattern)) return false;
                else {
                    map1.put(fromString, fromPattern);
                    map2.put(fromPattern, true);
                }
            }
        }
        return true;
    }

    public static int findNumericalPattern(String str){
        Map<Character, Set<Integer>> myMap = new HashMap<>();
        char[] charArr = str.toCharArray();

        for(int i=0; i<charArr.length; i++){
            if(!myMap.containsKey(charArr[i])){
                myMap.put(charArr[i], new HashSet<>());
            }
            myMap.get(charArr[i]).add(i);
        }


        return 0;

    }


    public static int partitionString(String s) {
        Map<Character, Boolean> myMap = new HashMap<>();
        Set<Character> mySet = new HashSet<>();
        int result = 1;

        for(Character c: s.toCharArray()){
            if(mySet.contains(c)){
                result++;
                mySet.clear();
            }
            mySet.add(c);
        }
        return result;
    }

    public static int countDistinctIntegers(int[] nums) {
        Set allNums = new HashSet<>();

        for(int i:nums){
            allNums.add(i);
            String temp = String.valueOf(i);
            StringBuilder sb = new StringBuilder();
            for(int j = temp.length()-1; j>=0; j--){
                Character c = temp.charAt(j);
                sb.append(c);
            }
            String reversed = sb.toString();
            int reversedNum = Integer.parseInt(reversed);
            allNums.add(reversedNum);
        }

        System.out.println(allNums.toString());
        return allNums.size();
    }


    public static List<Boolean> checkArithmeticSubarrays(int[] nums, int[] l, int[] r) {
        List<Boolean> result = new ArrayList<>();

        for(int i=0; i<l.length; i++){
            int startIndex = l[i];
            int endIndex = r[i];
            int[] temp = Arrays.copyOfRange(nums, startIndex, endIndex+1);
            Arrays.sort(temp);
            int diff = temp[1]-temp[0];
            int count = 1;

            for(int j=1; j<temp.length; j++){
               if(temp[j]-temp[j-1]!=diff){
                   break;
               }
               count++;
            }
            if(count==temp.length){
                result.add(true);
            } else{
                result.add(false);
            }
        }
        return result;
    }

    public static int[] pivotArray(int[] nums, int pivot) {
        int[] result = new int [nums.length] ;
        int i = 0, j = nums.length-1, p = i, q = j ;

        while (i < nums.length && j >= 0) {
            if (nums[i] < pivot) result[p++] = nums[i] ;
            if (nums[j] > pivot) result[q--] = nums[j] ;
            i++ ;
            j-- ;
        }

        while (p <= q) result[p++] = pivot ;
        return result ;
    }


    public static List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean added = false;

        for(int num : nums){
            for(List<Integer> list : result){
                if(!list.contains(num)){
                    list.add(num);
                    added=true;
                    break;
                }
            }
            if(added==true){
                added=false;
                continue;
            } else {
                List<Integer> temp = new ArrayList<>();
                temp.add(num);
                result.add(temp);
            }
            added=false;
        }
        return result;
    }


    public static List<List<Integer>> groupPeople(int[] groups){ //{2,1,3,3,3,2};
        List<List<Integer>> result = new ArrayList<>();
        Map<Integer, List<Integer>> myMap = new HashMap<>();

        for(int i=0; i<groups.length; i++){
            int currVal = groups[i];
            if(myMap.get(currVal)!=null){
                myMap.get(currVal).add(i);
            } else{
                myMap.put(currVal, new ArrayList<>());
                myMap.get(currVal).add(i);
            }
            if(myMap.get(currVal).size()>=currVal){
                result.add(myMap.get(currVal));
                myMap.remove(currVal);
            }
        }

        return result;
    }


    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int writePointer = 1;

        for (int readPointer = 1; readPointer < nums.length; readPointer++) {
            if (nums[readPointer] != nums[readPointer - 1]) {
                nums[writePointer] = nums[readPointer];
                writePointer++;
            }
        }

        return writePointer;
    }

    public static String findLongestString(String[] stringList) {
        String longestString = "";
        for (String str : stringList) {
            if (str.length() > longestString.length()) {
                longestString = str;
            }
        }
        return longestString;
    }

    public static int[] findMaxMin(int[] myList) {
        int maximum = myList[0];
        int minimum = myList[0];
        for (int num : myList) {
            if (num > maximum) {
                maximum = num;
            } else if (num < minimum) {
                minimum = num;
            }
        }
        return new int[]{maximum, minimum};
    }


    public static int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }

    public static List<Integer> streamMax(int[] nums){
        Heap maxHeap = new Heap();
        List<Integer> result = new ArrayList<>();

        for (int num : nums) {
            maxHeap.insert(num);
            result.add(maxHeap.getHeap().get(0));
        }
        return result;
    }

    public static int findKthSmallest1(int[] nums, int k) {
        Heap maxHeap = new Heap();

        for (int num : nums) {
            maxHeap.insert(num);
            if (maxHeap.getHeap().size() > k) {
                maxHeap.remove();
            }
        }

        return maxHeap.remove();
    }

    public static int findKthSmallest2(int[] nums, int k){
        Heap myHeap = new Heap();
        for(int num:nums){
            myHeap.insert(num);
        }

        while(myHeap.getHeap().size()>0){
            if(myHeap.getHeap().size()==k){
                return myHeap.remove();
            }
            myHeap.remove();
        }

        return 0;
    }

    public static int longestConsecutiveSequence(int[] nums) {
        Set<Integer> numSet = new HashSet<>();
        for (int num : nums) {
            numSet.add(num);
        }
        int longestStreak = 0;

        for (int num:numSet){
            if(!numSet.contains(num-1)){
                int currentNum = num;
                int currentStreak = 1;
                while(numSet.contains(currentNum+1)){
                    currentNum++;
                    currentStreak+=1;
                }
                longestStreak=Math.max(currentStreak, longestStreak);
            }
        }
        return longestStreak;
    }


    public static List<int[]> findPairs(int[] arr1, int[] arr2, int target){
        Set<Integer> mySet = new HashSet<>();
        List<int[]> result = new ArrayList<>();

        for(int i: arr1){
            mySet.add(target-i);
        }

        for(int i:arr2){
            if(mySet.contains(i)){
                result.add(new int[]{target-i, i});
            }
        }
        return result;
    }


    public static boolean hasUniqueChars(String str){
        Set<Character> mySet = new HashSet<>();

        for(char c: str.toCharArray()){
            mySet.add(c);
        }

        if(mySet.size()==str.length()){
            return true;
        }

        return false;
    }

    public static List<Integer> removeDuplicates(List<Integer> myList) {
        Set<Integer> uniqueSet = new HashSet<>(myList);
        return new ArrayList<>(uniqueSet);
    }


    public static int[] subarraySum(int[] nums, int target) {
        Map<Integer, Integer> sumIndex = new HashMap<>();
        sumIndex.put(0, -1);
        int currentSum = 0;

        for (int i = 0; i < nums.length; i++) {
            currentSum += nums[i];
            if (sumIndex.containsKey(currentSum - target)) {
                return new int[]{sumIndex.get(currentSum - target) + 1, i};
            }
            sumIndex.put(currentSum, i);//0->-1 / 2->0 / 6->1 / 7->2
        }

        return new int[]{};
    }


    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            if (numMap.containsKey(target - nums[i])) {
                return new int[]{numMap.get(target - nums[i]), i};
            }
            numMap.put(nums[i], i);
        }

        return new int[]{};
    }



    public static List<List<String>> groupAnagrams(String[] strings) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String string : strings) {
            char[] chars = string.toCharArray();
            Arrays.sort(chars);
            String canonical = new String(chars);

            if (anagramGroups.containsKey(canonical)) {
                anagramGroups.get(canonical).add(string);
            } else {
                List<String> group = new ArrayList<>();
                group.add(string);
                anagramGroups.put(canonical, group);
            }
        }

        return new ArrayList<>(anagramGroups.values());
    }


    public static Character firstNonRepeatingChar(String str){
        Map<Character, Integer> myMap = new HashMap<>();

        for(char c:str.toCharArray()){
            if(myMap.get(c)!=null){
                myMap.put(c, myMap.get(c)+1);
            } else {
                myMap.put(c, 1);
            }
        }

        for(char c:str.toCharArray()){
            if(myMap.get(c)==1){
                return c;
            }
        }
        return null;
    }

    public static List<Integer> findDuplicates(int[] arr){
        List<Integer> duplicates = new ArrayList<>();
        Map<Integer, Boolean> myMap = new HashMap<>();
        for(int num:arr){
            if(myMap.get(num)!=null){
                duplicates.add(num);
            }

            myMap.put(num, true);
        }
        return duplicates;
    }

    public static boolean itemInCommon(int[] array1, int[] array2) {
        HashMap<Integer, Boolean> myHashMap = new HashMap<>();

        for (int i : array1) {
            myHashMap.put(i, true);
        }

        for (int j : array2) {
            if (myHashMap.get(j) != null) return true;
        }

        return false;
    }

    public static Stack2<Integer> sortStack(Stack2<Integer> stack){
        Stack2<Integer> sortedStack = new Stack2<>();

        int temp;

        while(!stack.isEmpty()){
            temp = stack.pop();
            while(!sortedStack.isEmpty() && temp<sortedStack.peek()){
                stack.push(sortedStack.pop());
            }
            sortedStack.push(temp);
        }
        return sortedStack;
    }

    public static String reverseString(String string){
        Stack2<Character> st = new Stack2();
        for(char c:string.toCharArray()){
            st.push(c);
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        return sb.toString();
    }

    public static void bubbleSort(int[] list){

        for(int i=list.length-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(list[j] > list[j+1]){
                    int temp = list[j];
                    list[j]=list[j+1];
                    list[j+1]=temp;
                }
            }
        }
    }

    public static void bubbleSort2(ArrayList<Integer> list){

        for(int i=list.size()-1; i>0; i--){
            for(int j=0; j<i; j++){
                if(list.get(j) > list.get(j+1)){
                    int temp = list.get(j);
                    list.set(j, list.get(j+1));
                    list.set(j+1, temp);
                }
            }
        }
    }

    public static void selectionSort(int[] list){
        int temp;
        int minIndex;

        for(int i=0; i<list.length; i++){
            minIndex = i;
            for(int j = minIndex+1; j<list.length; j++){
                if(list[j]<list[minIndex]){
                    minIndex=j;
                }
            }
            if(minIndex!=i){
                temp = list[i];
                list[i] = list[minIndex];
                list[minIndex]=temp;
            }

        }
    }

    public static void insertionSort(int[] list){

        int temp;
        for(int i=1; i<list.length; i++){
            int currentIndex = i;
            while(currentIndex>=1 && list[currentIndex]<list[currentIndex-1]){
                temp = list[currentIndex];
                list[currentIndex]=list[currentIndex-1];
                list[currentIndex-1]=temp;
                currentIndex=currentIndex-1;
            }
        }
    }

    public static int[] mergeSort(int[] array){  // [3, 1, 4, 2]
        if(array.length==1) return array;

        int midIndex = array.length/2;
        int[] leftArray = mergeSort(Arrays.copyOfRange(array, 0, midIndex));
        int[] rightArray = mergeSort(Arrays.copyOfRange(array, midIndex, array.length));

        return merge(leftArray, rightArray);
    }

    public static int[] merge(int [] arr1, int [] arr2){
        int [] mergedArray = new int    [arr1.length + arr2.length];
        int index = 0;
        int i = 0;
        int j = 0;
        while(i<arr1.length && j<arr2.length){
            if(arr1[i]<arr2[j]){
                mergedArray[index] = arr1[i];
                index++;
                i++;
            } else if (arr2[j]<arr1[i]) {
                mergedArray[index] = arr2[j];
                index++;
                j++;
            }
        }
        while(i<arr1.length){
            mergedArray[index]=arr1[i];
            index++;
            i++;
        }
        while(j<arr2.length){
            mergedArray[index]=arr2[j];
            index++;
            j++;
        }

        return mergedArray;
    }


}


