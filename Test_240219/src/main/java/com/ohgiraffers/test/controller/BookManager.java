package com.ohgiraffers.test.controller;

import com.ohgiraffers.test.model.comparator.AscCategory;
import com.ohgiraffers.test.model.comparator.DescCategory;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.ArrayList;
import java.util.Comparator;

public class BookManager {
    ArrayList<BookDTO> arrList;
    public BookManager(){
        arrList = new ArrayList<>();
    }
    public void addBook(BookDTO book){
        arrList.add(book);
    }
    public void deleteBook(int index){
        boolean isTrue = true;

        for(int i=0; i<arrList.size(); i++){
            int num = arrList.get(i).getbNo();
            if(num == index){
                isTrue = false;
                System.out.println(arrList.remove(i) + "(이)가 삭제되었습니다.");
            }
        }

        if(isTrue) System.out.println("일치하는 도서 번호가 없습니다.");
    }
    public int searchBook(String bTitle){
        for(int i=0; i<arrList.size(); i++){
            String str = arrList.get(i).getTitle();
            if(str.contains(bTitle)){
                return i;
            }
        }

        return -1;
    }
    public void printBook(int index){
        if(index != -1) {
            System.out.println(arrList.get(index));
        } else {
            System.out.println("일치하는 도서 제목이 없습니다.");
        }
    }
    public void displayAll(){
        for(int i=0; i<arrList.size(); i++){
            System.out.println(arrList.get(i));
        }
    }
    public ArrayList<BookDTO> sortedBookList(int select){
//        1.오름차순 / 2.내림차순

        switch (select){
            case 1 :
                Comparator<BookDTO> ascList = new AscCategory();
                arrList.sort(ascList);
                break;
            case 2 :
                Comparator<BookDTO> descList = new DescCategory();
                arrList.sort(descList);
                break;
            default:
                System.out.println("보기 중에서 선택해주세요");
                break;
        }

        return arrList;
    }
    public void printBookList(ArrayList<BookDTO> br){
        for(BookDTO i : br){
            System.out.println(i);
        }
    }
}
