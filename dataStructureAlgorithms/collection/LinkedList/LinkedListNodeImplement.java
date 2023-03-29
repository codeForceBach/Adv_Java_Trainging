package dataStructureAlgorithms.collection.LinkedList;

    public class LinkedListNodeImplement{
        //initialize node
        LinkedNode head;

        public void InsertAt(int index, Object data) throws IndexOutOfBoundsException{
            if (index > size() || index <= 0){
                throw new IndexOutOfBoundsException("the size of the Node is " + size());
            } else if (index == 1){
                insertAtFirst(data);
            } else if (index == size()){
                insertAtEnd(data);
            } else {
                LinkedNode tempNode = head;
                LinkedNode newNode = new LinkedNode();
                for(int i = 1; i < index; i++){
                    if(i == index){
                        newNode.data = data;
                        newNode.next = tempNode.next;
                        tempNode.next = newNode;
                    } else {
                        tempNode = tempNode.next;
                    }
                }
            }//end if else
        }//end insertAt

        public void insertAtFirst(Object data){
            LinkedNode newNode = new LinkedNode();
            newNode.data = data;
            if(head == null){
                head = newNode;
            } else {
                LinkedNode tempNode = head;
                head = newNode;
                newNode.next = tempNode;
            }
        }
        /*
        create a node at the end of the last node
         */
        public void insertAtEnd (Object data){
                LinkedNode tail = new LinkedNode();
                tail.data = data;

                if(head == null){
                    head = tail;
                } else {
                    LinkedNode tempHead = head;
                    while (tempHead.next != null) {
                        tempHead = tempHead.next;
                    }
                    tempHead.next = tail;
                }//end if else
        }//end insertAtEnd

        public void deleteAt(int index) throws IndexOutOfBoundsException {
            if (size() < index || index < 1) {
                throw new IndexOutOfBoundsException("the index is out of size limit of the LinkedList");
            }

            if (index == 1){
                head = head.next;
            } else {
                LinkedNode tempNode = head;
                LinkedNode newNode = null;
                for (int i = 1; i < index-1; i++) {
                    tempNode = tempNode.next;
                }//end for
                newNode = tempNode.next;
                tempNode.next = newNode.next;
            }

        }//end delete

        /* WORK IN PROGRESS!!
        delete node contain specific data if the value is in nodelist and return true.
        if value is not present in all node, return false
         */
        public boolean delete(Object data){
            boolean deleted = false;
            LinkedNode tempNode = head;

                for (int i = 1; i <= size(); i++) {

                    if(tempNode.data.equals(data)){
                        deleted = true;
                        if (tempNode.next != null) {
                            LinkedNode newNode = tempNode.next;
                            tempNode.next = newNode.next;
                        } else {
                            tempNode = null;
                        }

                    }
                    tempNode = tempNode.next;
                }


                return deleted;
        }

        /*
        return 1 indexes Node data
         */
        public Object getData(int index) throws IndexOutOfBoundsException{

            if (size() < index) {
                throw new IndexOutOfBoundsException("the index is out of size limit of the LinkedList");
            }

            LinkedNode tempNode = head;
            Object obj = null;
            //below while loop - requires additional step to count the last node in the list
            /*
            int count = 0;
            while (tempNode.next != null) {
                count++;
                if (index == count) {
                    obj = tempNode.data;
                } else {
                    tempNode = tempNode.next;
                }
            }
            count++;
            if(index == count){
                obj = tempNode.data;
            }*/
            for (int i = 0 ; i < index ; i++){
                if (i+1 == index){
                    obj = tempNode.data;
                }else {
                    tempNode = tempNode.next;
                }
            }
            return obj;
        }

        public int size(){
            int size = 0;
            LinkedNode sizeNode = head;
            if(sizeNode != null){
                while (sizeNode.next != null){
                    sizeNode = sizeNode.next;
                    size++;
                }
                size++;
            }
            return size;
        }

        public void shows(){

            LinkedNode loopNode = head;

            while(loopNode.next != null){

                System.out.println(loopNode);
                loopNode = loopNode.next;
            }
            System.out.println(loopNode);

        }

    }


