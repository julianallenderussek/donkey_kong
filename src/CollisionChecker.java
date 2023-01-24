public class CollisionChecker {
    GamePanel gp;

    public CollisionChecker(GamePanel gp) {
        this.gp = gp;
    }
    
    // Implementatin of collission logic, depending on entity
    public void checkCollision(Entity entity, String type) {
        switch(type) {
            case "player":
            break;
            case "kong":
            break;
            case "barrel":
            break;
        }
    }
}
