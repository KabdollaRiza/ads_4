import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class Vertex {
    public class Vertex<T> {
        private T data;
        private Map<Vertex<T>, Double> adjacentVertices;

        // getters&setters constructors

        public T getData() {
            return data;
        }

        public void setData(T data) {
            this.data = data;
        }

        public Map<Vertex<T>, Double> getAdjacentVertices() {
            return adjacentVertices;
        }

        public void setAdjacentVertices(Map<Vertex<T>, Double> adjacentVertices) {
            this.adjacentVertices = adjacentVertices;
        }

        public Vertex(){
            this.data=data;
            this.adjacentVertices=new HashMap<>();
        }

        // equals

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Vertex<?> vertex = (Vertex<?>) o;
            return Objects.equals(data, vertex.data) && Objects.equals(adjacentVertices, vertex.adjacentVertices);
        }

        @Override
        public int hashCode() {
            return Objects.hash(data, adjacentVertices);
        }


    }
}
