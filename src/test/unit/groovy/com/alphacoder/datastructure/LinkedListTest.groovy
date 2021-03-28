package com.alphacoder.datastructure

import spock.lang.Specification

class LinkedListTest extends Specification{

    def 'Test LinkedList | isEmpty() | LinkedList is empty'(){
        given:
        def list= new LinkedList();

        when:
        def result= list.isEmpty()

        then:
        result== true;

    }

    def 'Test LinkedList | size() | size is 0'(){
        given:
        def list= new LinkedList();

        when:
        def result= list.size()

        then:
        result== 0;

    }

    def 'Test LinkedList | insert() | insert single element in an empty list'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(3,0)

        then:
        list.isEmpty()== false;
        list.size()== 1

        and:
        list.get(0)== 3
    }

    def 'Test LinkedList | insert() | IndexOutOfBoundsException with -ve index'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(3,-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | IndexOutOfBoundsException with invalid index'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(3,1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | insert() | insert multiple elements in an empty list'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(3, 0)
        list.insert(5, 1)
        list.insert(2, 2)

        then:
        list.isEmpty()== false;
        list.size()== 3

        and:
        list.get(0)== 3
        list.get(1)== 5
        list.get(2)== 2
    }

    def 'Test LinkedList | insert() | insert multiple elements in between'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(3, 0)
        list.insert(5, 1)
        list.insert(2, 2)
        list.insert(4, 1)
        list.insert(7, 2)
        list.insert(5, 5)

        then:
        list.isEmpty()== false;
        list.size()== 6

        and:
        list.get(0)== 3
        list.get(1)== 4
        list.get(2)== 7
        list.get(3)== 5
        list.get(4)== 2
        list.get(5)== 5
    }

    def 'Test LinkedList | update() | IndexOutOfBoundsException with -ve index'(){
        given:
        def list= new LinkedList();

        when:
        list.update(3,-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | update() | IndexOutOfBoundsException with invalid index'(){
        given:
        def list= new LinkedList();

        when:
        list.update(3,0)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | update() | Update first element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.update(3,0)

        then:
        list.isEmpty()== false
        list.size()== 1

        and:
        list.get(0)== 3
    }

    def 'Test LinkedList | update() | Update last element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(2, 2)
        list.update(3,2)

        then:
        list.isEmpty()== false
        list.size()== 3

        and:
        list.get(0)== 1
        list.get(1)== 2
        list.get(2)== 3
    }

    def 'Test LinkedList | update() | Update in between element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(2, 2)
        list.insert(2, 3)
        list.insert(2, 4)
        list.update(3,2)
        list.update(3, 2)
        list.update(4, 3)
        list.update(5, 4)

        then:
        list.isEmpty()== false
        list.size()== 5

        and:
        list.get(0)== 1
        list.get(1)== 2
        list.get(2)== 3
        list.get(3)== 4
        list.get(4)== 5
    }

    def 'Test LinkedList | delete() | IndexOutOfBoundsException with -ve index'(){
        given:
        def list= new LinkedList();

        when:
        list.delete(-1)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | delete() | IndexOutOfBoundsException with invalid index'(){
        given:
        def list= new LinkedList();

        when:
        list.delete(0)

        then:
        thrown(IndexOutOfBoundsException)
    }

    def 'Test LinkedList | delete() | Delete first element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.delete(0)

        then:
        list.isEmpty()== true
        list.size()== 0

    }

    def 'Test LinkedList | delete() | Delete last element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(2, 2)
        list.delete(2)

        then:
        list.isEmpty()== false
        list.size()== 2

        and:
        list.get(0)== 1
        list.get(1)== 2
    }

    def 'Test LinkedList | delete() | Delete in between element'(){
        given:
        def list= new LinkedList();

        when:
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(2, 2)
        list.insert(4, 3)
        list.insert(5, 4)
        list.delete(1)
        list.delete(1)

        then:
        list.isEmpty()== false
        list.size()== 3

        and:
        list.get(0)== 1
        list.get(1)== 4
        list.get(2)== 5
    }

    def 'Test LinkedList | reverse() | Reverse an empty list'(){
        given:
        def list= new LinkedList();

        when:
        list.reverse();

        then:
        thrown(UnsupportedOperationException)
    }

    def 'Test LinkedList | reverse() | Delete single element list'(){
        given:
        def list= new LinkedList();
        list.insert(1, 0)

        when:
        list.reverse()


        then:
        list.isEmpty()== false
        list.size()== 1

        and:
        list.get(0)== 1

    }

    def 'Test LinkedList | reverse() | Reverse list'(){
        given:
        def list= new LinkedList();
        list.insert(1, 0)
        list.insert(2, 1)
        list.insert(3, 2)
        list.insert(4, 3)

        when:
        list.reverse()


        then:
        list.isEmpty()== false
        list.size()== 4

        and:
        list.get(0)== 4
        list.get(1)== 3
        list.get(2)== 2
        list.get(3)== 1

    }
}
