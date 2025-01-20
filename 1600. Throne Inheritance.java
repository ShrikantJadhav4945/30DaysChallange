import java.util.*;

class ThroneInheritance {
    private String king;
    private Map<String, List<String>> familyTree; // Adjacency list for family tree
    private Set<String> deceased; // Set of deceased individuals
    
    public ThroneInheritance(String kingName) {
        this.king = kingName;
        this.familyTree = new HashMap<>();
        this.deceased = new HashSet<>();
        this.familyTree.put(kingName, new ArrayList<>());
    }
    
    public void birth(String parentName, String childName) {
        familyTree.putIfAbsent(parentName, new ArrayList<>());
        familyTree.get(parentName).add(childName);
        familyTree.put(childName, new ArrayList<>()); // Initialize child's list
    }
    
    public void death(String name) {
        deceased.add(name);
    }
    
    public List<String> getInheritanceOrder() {
        List<String> order = new ArrayList<>();
        preorder(king, order);
        return order;
    }
    
    private void preorder(String current, List<String> order) {
        if (!deceased.contains(current)) {
            order.add(current);
        }
        for (String child : familyTree.getOrDefault(current, new ArrayList<>())) {
            preorder(child, order);
        }
    }
}
