function array_max() {
    var i,max = this[0];
    for(i = 1; i < this.length; i++){
        if (max < this[i]){
            max = this[i];
        }
    }

    return max;
}
// alert("ddd")
// Array.prototype.max = array_max;
// var s = new Array(1,2,3,5,6)
// var max = s.max();
// alert(max)