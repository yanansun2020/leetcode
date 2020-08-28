package oa.amazon.oa2;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class ManagerNodes {
    public int maxAge(EmployeeNode root){
        Tenure tenure = getTenure(root);
        return tenure.node.value;
    }
    public Tenure getTenure(EmployeeNode node){
        if(node.children == null || node.children.size() == 0){
            return new Tenure(-1.0f, 1, node.value, node);
        }
        Tenure maxTenure = null;
        float maxAvg = -1.0f;
        int tmpSum = 0;
        int tmpNodeNumber = 0;
        for(int i =0 ; i < node.children.size(); i++){
            Tenure tenure = getTenure(node.children.get(i));
            if(tenure.average > maxAvg){
                maxTenure = tenure;
                maxAvg = tenure.average;
            }
            tmpSum += tenure.sum;
            tmpNodeNumber += tenure.nodeNumbers;
        }
        tmpNodeNumber += 1;
        tmpSum += node.value;
        float tmpAvrg = (tmpSum/tmpNodeNumber);
        if(tmpAvrg > maxAvg){
            maxTenure = new Tenure(tmpAvrg, tmpNodeNumber, tmpSum, node);
        }
       return new Tenure(maxTenure.average, tmpNodeNumber, tmpSum, maxTenure.node);
    }

    //pass all test case
    private NetworkNode result = null;
    private double tmpMaxAvg;
    public NetworkNode getHighestSection(NetworkNode rootComponent){
        if(rootComponent == null){
            return null;
        }
        result = null;
        tmpMaxAvg = -1.0;
        recurHelper(rootComponent);
        return result;
    }

    private long[] recurHelper(NetworkNode curNode) {
        if(null == curNode.children || curNode.children.size() < 1){
            return new long[]{1, curNode.value};
        }
        long curTotal = curNode.value, curNum = 1;
        for(NetworkNode node :curNode.children){
            long[] tmp = recurHelper(node);
            curNum += tmp[0];
            curTotal += tmp[1];
        }
        if((double)curTotal/(double)curNum > tmpMaxAvg){
            tmpMaxAvg = (double)curTotal/(double)curNum;
            result = curNode;
        }
        return new long[]{curNum, curTotal};
    }

    @Test
    public void test(){
        EmployeeNode root = new EmployeeNode(20);
        EmployeeNode right = new EmployeeNode(18);
        right.children = new ArrayList<EmployeeNode>(){
            {
                add(new EmployeeNode(15));
                add(new EmployeeNode(8));
            }
        };
        EmployeeNode left = new EmployeeNode(12);
        left.children = new ArrayList<EmployeeNode>(){
            {
                add(new EmployeeNode(11));
                add(new EmployeeNode(2));
                add(new EmployeeNode(3));
            }
        };

        root.children= new ArrayList<EmployeeNode>(){
            {
                add(left);
                add(right);
            }
        };
        int ans = maxAge(root);
        System.out.println(1);
    }
}

class Tenure{
    float average;
    int nodeNumbers;
    int sum;
    EmployeeNode node;
    Tenure(){}
    Tenure(float average, int nodeNumbers, int sum, EmployeeNode node){
        this.average = average;
        this.nodeNumbers = nodeNumbers;
        this.sum = sum;
        this.node = node;
    }
}
class EmployeeNode{
    int value;
    List<EmployeeNode> children;
    EmployeeNode(int val){
        this.value = val;
    }
}

class NetworkNode{
    int value;
    List<NetworkNode> children;
    NetworkNode(int val){
        this.value = val;
    }
}
