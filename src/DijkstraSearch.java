class DijkstraSearch<T> implements Search<T> {
    private Map<Vertex<T>, Vertex<T>> edgeTo;
    private Map<Vertex<T>, Double> distTo;
    private PriorityQueue<Vertex<T>> pq;

    public DijkstraSearch(WeightedGraph<T> graph, T source) {
        edgeTo = new HashMap<>();
        distTo = new HashMap<>();
        pq = new PriorityQueue<>((a, b) -> Double.compare(distTo.get(a), distTo.get(b)));
        dijkstra(graph, graph.getVertex(source));
    }

    private void dijkstra(WeightedGraph<T> graph, Vertex<T> source) {
        pq.offer(source);
        distTo.put(source, 0.0);
        edgeTo.put(source, null);

        while (!pq.isEmpty()) {
            Vertex<T> u = pq.poll();
            for (Map.Entry<Vertex<T>, Double> entry : u.getNeighbors().entrySet()) {
                Vertex<T> v = entry.getKey();
                double weight = entry.getValue();
                relax(v, u, weight);
            }
        }
    }

    private void relax(Vertex<T> v, Vertex<T> u, double weight) {
        if (!distTo.containsKey(v) || distTo.get(u) + weight < distTo.get(v)) {
            distTo.put(v, distTo.get(u) + weight);
            edgeTo.put(v, u);
            pq.offer(v);
        }
    }

    @Override
    public List<T> pathTo(T destination) {
        List<T> path = new ArrayList<>();
        for (Vertex<T> v = getVertex(destination); v != null; v = edgeTo.get(v)) {
            path.add(0, v.getValue());
        }
        return path;
    }

    private Vertex<T> getVertex(T value) {
        for (Vertex<T> v : edgeTo.keySet()) {
            if (v.getValue().equals(value)) {
                return v;
            }
        }
        return null;
    }
}