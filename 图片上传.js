//https://www.npmjs.com/package/element-china-area-data







<template>

  <div id="app">

    <div class="container">

      <div class="imgContainer">

        <div class="itemImg" v-for="(item,index) in imgList" :key="index">

          <img :src="item" alt="" >

​     <a-icon type="delete" class="deletIcon" v-if="imgList.length" @click="deleteImg(index)"/>

​    </div>

   </div>



      <div class="upLost">

​    <a-icon type="plus" class="upIcon"/>

​    <input type="file" class="upfile" title="" accept=".jpg" @change="upUserFile"/>

​    

   </div>

  </div>

  

 </div>

</template>



<script>





 name: 'App',

 components: {},

 data(){

  return{

   imgList:[],*//图片url地址*



  }

 },

 methods:{

  upUserFile(event){

   let files = event.target.files

   let file = files[0]
	
	if(!file.value){
		alert("没有选择图片")

​     	return
	}else if(file.size > 1024*1024*2){

​     alert("图片不能大于2M")

​     return

   }else if(file.type !== 'image/jpeg' && file.type !== 'image/png' && file.type !== 'image/gif'){
	   alert("不是有效图片,请重新上传")
   }

   

   let url = window.URL || window.webkitURL

   let imgURL = url.createObjectURL(file) //上传的文件url地址

   this.imgList.push(imgURL)

   

  },



  deleteImg(index){*//删除图片的回调*

   this.imgList.splice(index,1)

  },

 }



}

</script>



<style scoped>

.container{

 width: 800px;

 height: 150px;

 display: flex;

 flex-direction: row;



}

.imgContainer{

 display: flex;

 height: 100%;

}

.itemImg{

 position: relative;

 height: 100%;

}

.itemImg img{

 width: 150px;

 height: 100%;

 margin-right: 4px;

}

.upLost{

 position: relative;

 width: 150px;

 height: 100%;

 text-align: center;

 border: 1px dashed #C1C1C1;

}

.upIcon{

 margin-top: 40px;

 font-size: 50px;

}

.upfile{

 width: 150px;

 height: 100%;

 position: absolute;

 top: 0;

 left: 0;

 opacity: 0;

}

.deletIcon{

 font-size: 20px;

 color: white;

 position: absolute;

 top: 10px;

 right: 10px;

}

.deletIcon:hover{
 color: red;
}

</style>
