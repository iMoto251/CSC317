package PolyCalc;

import java.util.*;

public class Polynomial {

    private List<Polyterm> listP;
	
	public Polynomial add(Polynomial poly) {
        List<Polyterm> output = new ArrayList<>();
        output.addAll(this.getListP());
        output.addAll(poly.getListP());

        Polynomial p = unite(output);
        return p;
    }
	
	public Polynomial mult(Polynomial poly) {
        List<Polyterm> output = new ArrayList<>();
        for (Polyterm x : poly.getListP()) {
            for (Polyterm y : getListP()) {
                output.add(x.mult(y));
            }
        }
        return (unite(output));
    }
	
	public Scalar evaluate(Scalar scalar) {
        if (getListP().size() == 0) {
            return null;
        } else {
            Scalar s = getListP().get(0).evaluate(scalar);
            for (int i = 1; i < getListP().size(); i = i + 1) {
                s = s.add(getListP().get(i).evaluate(scalar));
            }
            return s;
        }
    }
	
	public Polynomial derivative() {
        List<Polyterm> list = new ArrayList<>();
        for (int i = 0; i < getListP().size(); i = i + 1) {
            Polyterm p = getListP().get(i).derivative();
            if (!(p.getScalar().toString().equals("0") | (p.getScalar().toString().equals("0.0")))) {
                list.add(p);
            }
        }
        Polynomial p = unite(list);
        return p;
    }
	
	public String toString() {

        String s = "";
        for (int i = 0; i < getListP().size(); i = i + 1) {
            Polyterm p = getListP().get(i);
            if (i != 0) {
                if (p.getIndication().equals("+")) {
                    s += p.getIndication() + p.toString();
                } else {
                    s += p.toString();
                }
            } else {
                s+= p.toString();
            }
        }
        while (s.indexOf('+')==0){
            s=s.substring(1);
        }
        if (s.equals("")){
            s="0";
        }
        return s;
    }
	
	public boolean equals(Polynomial poly) {
        boolean isEqual = true;
        if (poly.getListP().size() != getListP().size()) {
            isEqual = false;
        }
        for (int i = 0; i < getListP().size() & isEqual; i = i + 1) {
            if (!poly.getListP().get(i).equals(getListP().get(i))) {
                isEqual = false;
            }
        }
        return isEqual;
    }
	
	//Added helpers
    public Polynomial(List<Polyterm> listP) {
        this.listP = listP;
    }

    public List<Polyterm> getListP() {
        return listP;
    }

    public void setCollection(List<Polyterm> listP) {
        this.listP = listP;
    }

    public Polynomial unite(List<Polyterm> listP) { //this function unite all the same exps in the list and return a sorted polinomial
        List<Polyterm> output = new ArrayList<>();
        boolean[] alreadyAdded = new boolean[listP.get(listP.size()-1).getExp()+1];
        for (int i = 0; i < listP.size(); i = i + 1) {
            Polyterm add = listP.get(i);
            for (int j = i + 1; j < listP.size() & !alreadyAdded[add.getExp()]; j = j + 1) {
                if (add.canAdd(listP.get(j))) {
                    add = add.add((listP.get(j)));
                }
            }
            if (!alreadyAdded[add.getExp()]) {
                output.add(add);
            }
            alreadyAdded[add.getExp()] = true;
        }

        // removes all 0 scalars
        for(int i = 0 ; i < output.size() ; i++){
            if(output.get(i).getScalar().toString().equals("0")){
                output.remove(output.get(i));
            }
        }

        return new Polynomial(output);
    }
}
