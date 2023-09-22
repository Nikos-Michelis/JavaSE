public class Main {

    public static void main(String[] args) {
        MyTreeMap<String, String> dict = new MyTreeMap<>();

        dict.put("ιταμός", "προκλητικός, αυθάδης, αναιδής");
        dict.put("όνειδος", "ντροπή, καταισχύνη");
        dict.put("πομφόλυγες", "αερολογίες, ανοησίες");

        for (var v: dict)
            System.out.println(v + ": " + dict.get(v));
    }
}