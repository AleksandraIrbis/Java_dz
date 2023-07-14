package market;
import java.util.*;

public class code {

    private Set<Notebook> notebooks = new HashSet<>();
    private List<Criterion> criterionList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public void printList(){
        for (Notebook notebook : notebooks){
            if (notebookIsCorrect(notebook)){
                System.out.println(notebook);
            }
        }
    }

    public boolean notebookIsCorrect(Notebook notebook){

        for (Criterion criterion : criterionList){
            Object valueNotebook = null;

            if (criterion.property.equals("имя")){
                valueNotebook = notebook.getName();
            }else if (criterion.property.equals("обьем Озу")){
                valueNotebook = notebook.getAmountRAM();
            }else if (criterion.property.equals("операционная система")){
                valueNotebook = notebook.getOperatingSystem();
            }else if (criterion.property.equals("цена")){
                valueNotebook = notebook.getPrice();
            }else if (criterion.property.equals("модель")){
                valueNotebook = notebook.getModel();
            }else {
                continue;
            }

            if (criterion.value != null && !criterion.value.equals(valueNotebook)){
                return false;
            }

            if (criterion.maxValue != null && criterion.maxValue < Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }

            if (criterion.minValue != null && criterion.minValue > Double.parseDouble(Objects.toString(valueNotebook))){
                return false;
            }
        }

        return true;
    }
    public code(Set<Notebook> notebooks) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
    }

    public code(Set<Notebook> notebooks, List<Criterion> criterionList) {
        this.scanner = new Scanner(System.in);
        this.notebooks = notebooks;
        this.criterionList = criterionList;
    }

    public int getCriteria(){
        String text = "Введите число, соответсвующему критерию: ";

        List<String> properties = propertiesForFilter();

        for (int i = 0; i < properties.size(); i++)
        {
            text += "\n" + (i + 1) + ". " + getPropertyDescription(properties.get(i));
        }

        System.out.println(text);

        int value = scanner.nextInt();

        return value;
    }

    public String getPropertyDescription(String property){

        Map<String, String> descriptionsProperties = descriptionsProperties();

        return descriptionsProperties.get(property);

    }

    public Map<String, String> descriptionsProperties(){
        Map<String, String> map = new HashMap<>();

        map.put("имя", "Имя");
        map.put("Обьем Озу", "обьем оперативки");
        map.put("операционная система", "Операционная система");
        map.put("цена", "Цена");
        map.put("модель", "Модель");

        return map;

    }

    public List<String> propertiesForFilter(){
        List<String> list = new ArrayList<>();
        list.add("имя");
        list.add("Обьем Озу");
        list.add("операционная система");
        list.add("цена");
        list.add("модель");

        return list;
    }

    public String getOperations(){

        String text = "Выберите функцию: \n " +
                "1. Добавить критерий \n " +
                "2. Показать весь список \n " +
                "3. Выход";

        System.out.println(text);

        String answer = scanner.next();

        return answer;
    }

    public Set<String> quantitativeSelection(){
        Set<String> set = new HashSet<>();
        set.add("обьем Озу");
        set.add("цена");

        return set;
    }

    public Set<String> stringSelection(){
        Set<String> set = new HashSet<>();

        set.add("имя");
        set.add("операционная система");
        set.add("модель");

        return set;
    }

    public void start(){

        boolean flag = true;
        while (flag){

            String operation = getOperations();
            if (operation.equals("3")){
                flag = false;
                scanner.close();
                continue;
            }else if(operation.equals("1")){

                int criterion = getCriteria();
                List<String> properties = propertiesForFilter();
                if (criterion - 1 < 0 || criterion - 1 > properties.size() - 1){
                    System.out.println("ошибка: введена неправильная величина");
                    continue;
                }
                String property = properties.get(criterion - 1);
                Criterion criterionObject = null;
                try {
                    if (quantitativeSelection().contains(property)){
                        criterionObject = Criterion.startGetting(scanner, property, true);
                    }else {
                        criterionObject = Criterion.startGetting(scanner, property, false);
                    }
                }catch (Exception e){
                    System.out.println("ошибка в выборе критерия");
                    continue;
                }
                if (criterionObject != null){
                    System.out.println("критерий добавлен");
                    criterionList.add(criterionObject);
                }
            }
            else if (operation.equals("2")){
                printList();
            }
        }
    }
}


class Criterion {

    Object value;
    Double minValue;
    Double maxValue;
    boolean isQuantitative;
    String property;

    public Criterion(String property, boolean isQuantitative, Object value, Double minValue, Double maxValue) {
        this.property = property;
        this.isQuantitative = isQuantitative;
        this.value = value;
        this.minValue = minValue;
        this.maxValue = maxValue;
    }

    public static Criterion startGetting(Scanner scanner, String property, boolean isQuantitative) {

        if (isQuantitative) {

            String quest = "Выберите критерий: " +
                    "\n 1. Цена" +
                    "\n 2. Меньше чем" +
                    "\n 3. Лучше чем" +
                    "\n 4. Интервал";
            System.out.println(quest);

            String text = scanner.next();

            Criterion criterion = null;

            if (text.equals("1")) {
                System.out.println("Введите величину ");
                int getValue = scanner.nextInt();
                criterion = new Criterion(property, isQuantitative, getValue, null, null);
            } else if (text.equals("2")) {
                System.out.println("Введите максимум: ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, null, getValue);
            } else if (text.equals("3")) {
                System.out.println("Введите минимальный лимит: ");
                double getValue = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, getValue, null);
            } else if (text.equals("4")) {
                System.out.println("Введите минимальную величину: ");
                double getMin = scanner.nextDouble();
                System.out.println("Введите максимальную величину: ");
                double getMax = scanner.nextDouble();
                criterion = new Criterion(property, isQuantitative, null, getMin, getMax);
            }

            return criterion;
        }

        System.out.println("Введите величину для поиска: ");
        String getValue = scanner.next();
        return new Criterion(property, isQuantitative, getValue, null, null);
}

}
