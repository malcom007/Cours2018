/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   PointColored.cpp
 * Author: mk
 * 
 * Created on 31 mai 2019, 09:01
 */

#include<iostream>
#include "PointColored.h"

using namespace std;

PointColored::PointColored(int abs, int ord, int couler):Point(abs, ord), Color(couler){
    cout<<"Const.PointColored"<<endl;
    
}

void PointColored::afficher(){
    Point::afficher();
    Color::afficher();
}


PointColored::~PointColored() {
    cout<<"delete poincolored"<<endl;
}



