class RandomWithWeight{
    List<Integer> data;
    int totWeight;
    Random rand;
    Map<String, Integer> indices;
    public RandomWithWeight(ArrayList<> input){
        data = input;
        rand = new Random();
        indices = new HashMap<>();
    }

    public String getRandomObject(){
        int w = rand.nextInt(totWeight);
        int i = 0;
        for(; i < data.size(); i++){
            w -= data.get(i).weight;
            if (w < 0){
                break;
            }
        }
        return data.get(i).obj;
    }

    public void setWeight(String obj, int w){
        
        if (indices.containsKey(obj)){
            int idx = indices.get(obj);
            Ele cur = data.get(idx);
            cur.weight = w;
            totWeight += w - cur.weight;

        } else {
            int idx = data.size();
            data.add(new Ele(ojb, w));
            totWeight += w;
        }
    }
}

class Ele{
    String obj;
    int weight;

    public Ele(String _obj, int _weight){
        obj = _obj;
        weight = _weight;
    }
}