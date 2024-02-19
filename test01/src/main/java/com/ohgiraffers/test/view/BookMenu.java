package com.ohgiraffers.test.view;

import com.ohgiraffers.test.controller.BookManager;
import com.ohgiraffers.test.model.dto.BookDTO;

import java.util.Scanner;

public class BookMenu {
    private Scanner sc = new Scanner(System.in);
    private BookManager bm = new BookManager();

    public BookMenu(){}
    public void menu(){
        label: while(true){
            System.out.println("=== 도서 관리 프로그램 ===\n1.도서 추가\n2.도서 삭제\n3.도서 검색\n4.전체 출력\n5.도서 목록 정렬\n0.프로그램 종료");
            System.out.print("프로그램 선택 : ");
            int index = sc.nextInt();
            sc.nextLine();

            switch (index){
                case 1 : bm.addBook(inputBook());
                    continue label;
                case 2 :
                    System.out.print("도서 번호 입력 : ");
                    int inputBno = sc.nextInt();
                    sc.nextLine();

                    bm.deleteBook(inputBno);
                    continue label;
                case 3 : int num = bm.searchBook(inputBookTitle());
                        bm.printBook(num);
                    continue label;
                case 4 : bm.displayAll();
                    continue label;
                case 5 :
                    System.out.println("1.오름차순 / 2.내림차순");
                    int selectNum = sc.nextInt();
                    sc.nextLine();

                    bm.printBookList(bm.sortedBookList(selectNum));
                    continue label;
                case 0 :
                    System.out.println("프로그램 종료");
                    break;
                default:
                    System.out.println("보기 중에서 선택해주세요");
                    break;
            }
            break;
        }
    }
    public BookDTO inputBook(){
        System.out.print("도서 번호 입력 : ");
        int inputBno = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 분류코드(1.인문 / 2.자연과학 / 3.의료 / 4.기타) 입력 : ");
        int inputCategory = sc.nextInt();
        sc.nextLine();
        System.out.print("도서 제목 입력 : ");
        String inputTitle = sc.nextLine();
        System.out.print("도서 저자 입력 : ");
        String inputAuthor = sc.nextLine();

        BookDTO book = new BookDTO(inputBno, inputCategory, inputTitle, inputAuthor);

        return book;
    }
    public String inputBookTitle(){
        System.out.print("도서 제목 입력 : ");
        String searchTitle = sc.nextLine();

        return searchTitle;
    }
}
