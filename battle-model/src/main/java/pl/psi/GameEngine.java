package pl.psi;

import pl.psi.creatures.Creature;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.Optional;

/**
 * TODO: Describe this class (The first line - until the first dot - will interpret as the brief description).
 */
public class GameEngine {

    public static final String CREATURE_MOVED = "CREATURE_MOVED";
    private final TurnQueue turnQueue;
    private final Board board;
    private final PropertyChangeSupport observerSupport = new PropertyChangeSupport(this);

    public GameEngine(final Hero aHero1, final Hero aHero2) {
        turnQueue = new TurnQueue(aHero1.getCreatures(), aHero2.getCreatures());
        board = new Board(aHero1.getCreatures(), aHero2.getCreatures());
    }

    public void attack(final Point point) {
        if (canAttack(point)) {
            board.getCreature(point)
                    .ifPresent(defender -> turnQueue.getCurrentCreature()
                            .attack(defender));
            pass();
        } else {
            throw new IllegalArgumentException("Creature cannot attack this point");
        }
    }

    public boolean canMove(final Point aPoint) {
        return board.canMove(turnQueue.getCurrentCreature(), aPoint);
    }

    public void move(final Point aPoint) {
        board.move(turnQueue.getCurrentCreature(), aPoint);
        observerSupport.firePropertyChange(CREATURE_MOVED, null, aPoint);
    }

    public Optional<Creature> getCreature(final Point aPoint) {
        return board.getCreature(aPoint);
    }

    public void pass() {
        turnQueue.next();
    }

    public void addObserver(final PropertyChangeListener aObserver) {
        observerSupport.addPropertyChangeListener(aObserver);
        turnQueue.addObserver(aObserver);
    }

    public boolean canAttack(final Point point) {
//        double distance = board.getPosition(turnQueue.getCurrentCreature())
//                .distance(point);
//        return board.getCreature(point)
//                .isPresent()
//                && distance < 2 && distance > 0;
        Creature currentCreature = turnQueue.getCurrentCreature();
        return currentCreature.getCanAttackStrategy().canAttack(board.getPosition(currentCreature), point) && board.getCreature(point).isPresent();
    }

    public boolean isCurrentCreature(Point aPoint) {
        return Optional.of(turnQueue.getCurrentCreature()).equals(board.getCreature(aPoint));
    }

    public Creature getCurrentCreature() {
        return turnQueue.getCurrentCreature();
    }
}
