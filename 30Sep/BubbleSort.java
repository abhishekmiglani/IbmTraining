class BubbleSort{
	public static void main(String[] args) {
		int arr[] = {1,2,23,12,8};

		int temp;
		int length = arr.length;

		for(int i = 0 ; i < length ;i++){
			for(int j = i+1 ; j < length ; j++,i++)
			{
				if(arr[i] > arr[j]){
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
			i=0;
			length--;
		}
		for(int value : arr)
			System.out.println(value);
	}
}
//01 12 23 34
//01 12 23