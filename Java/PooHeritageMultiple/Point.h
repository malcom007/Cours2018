/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   Point.h
 * Author: mk
 *
 * Created on 31 mai 2019, 08:42
 */

#ifndef POINT_H
#define POINT_H




class Point {
public:
    Point (int, int );
    virtual ~Point();
    void afficher();
private:
    int x, y;

};

#endif /* POINT_H */

