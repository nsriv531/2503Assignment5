package model;
/**
 * 
 * @author sriva
 *
 * @param <T>
 */
public interface HashInterface<T> {

int gethashCode(T key);
void put(T key) throws Exception;
T remove(T key);
void reset();
void printTable();
}
