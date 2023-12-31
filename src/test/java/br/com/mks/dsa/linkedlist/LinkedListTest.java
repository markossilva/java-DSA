package br.com.mks.dsa.linkedlist;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("LinkedList Class Test")
public class LinkedListTest {
    private LinkedList linkedList;
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();

    @BeforeEach
    void setUp() {
        System.setOut(new PrintStream(outputStreamCaptor));
        linkedList = new LinkedList(0);
    }

    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }

    @Test
    @DisplayName("Test append method validate head, tail and length methods")
    public void whenCreateANewEmptyLinkedListAppendAValue_ThenReturn_ThisValue() {
        var emptyLinkedList = new LinkedList();

        emptyLinkedList.append(1);

        assertEquals(1, emptyLinkedList.getTail().getValue());
        assertEquals(1, emptyLinkedList.getHead().getValue());
        assertEquals(1, emptyLinkedList.getLength());

        emptyLinkedList.append(2);
        assertEquals(2, emptyLinkedList.getTail().getValue());
    }

    @Test
    @DisplayName("Test with initialize linked list, removing the last item")
    public void whenCreateALinkedList_ThenRemoveTheLastItemAndHeadAndTailMustBeNull() {
        assertEquals(1, linkedList.getLength());

        final var removedLast = linkedList.removeLast();
        assertEquals(0, removedLast);

        assertTrue(Objects.isNull(linkedList.getHead()));
        assertTrue(Objects.isNull(linkedList.getTail()));
        assertEquals(0, linkedList.getLength());

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        assertEquals(3, linkedList.removeLast());
        assertTrue(Objects.isNull(linkedList.getTail().getNext()));

        linkedList = new LinkedList();
        final var removedLastWithEmptyList = linkedList.removeLast();
        assertTrue(Objects.isNull(removedLastWithEmptyList));
    }

    @Test
    @DisplayName("Create a LinkedList must be add an element on starts of the list")
    public void whenCreateALinkedList_mustBeAddAnElementOnStartsOfTheList() {

        linkedList = new LinkedList();
        assertTrue(Objects.isNull(linkedList.getHead()));
        assertTrue(Objects.isNull(linkedList.getTail()));
        assertEquals(0, linkedList.getLength());

        linkedList.prepend(1);
        assertEquals(1, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());
        assertEquals(1, linkedList.getLength());

        linkedList.prepend(2);

        assertTrue(Objects.nonNull(linkedList.getHead().getNext()));
        assertEquals(2, linkedList.getHead().getValue());
        assertEquals(1, linkedList.getTail().getValue());
        assertEquals(2, linkedList.getLength());

        linkedList.prepend(3);
        assertEquals(3, linkedList.getHead().getValue());
        assertEquals(3, linkedList.getLength());
    }

    @Test
    @DisplayName("Return how many times a list is show")
    public void whenCreatALinkedList_ThenReturnHomeManyTimesAListIsShow() {
        linkedList.printList();
        assertEquals("0", outputStreamCaptor.toString()
                .trim());
    }
}
