/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/* 
 * File:   PointColored.h
 * Author: mk
 *
 * Created on 31 mai 2019, 09:01
 */

#ifndef POINTCOLORED_H
#define POINTCOLORED_H

#include "Color.h"
#include "Point.h"


class PointColored:public Color, public Point {
public:
    PointColored(int, int,int);
    void afficher();
    virtual ~PointColored();
private:
    

};

#endif /* POINTCOLORED_H */

