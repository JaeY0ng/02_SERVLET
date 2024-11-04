/**
 * 
 */

console.log("myinfo..");


const formData = new FormData();


const profileBoxEl = document.querySelector(".profileBox");
const profileUploadBtn = document.querySelector(".profileUploadBtn");

//이미지 업로드 버튼 클릭 이벤트
profileUploadBtn.addEventListener("click",function(e){
	
	console.log("profileUploadBtn clicked...");
});


// drag , dragover dragstart dragend drop

       profileBoxEl.addEventListener('dragover',(e)=>{
           console.log("dragover",e)
           e.preventDefault();    
       })
       profileBoxEl.addEventListener('drop',(e)=>{
           console.log("drop",e)
           console.log("drop",e.dataTransfer)
           console.log("drop",e.dataTransfer.files)
           console.log("drop",e.dataTransfer.files[0])
           const file = e.dataTransfer.files[0];

           if(file.type.startsWith("image/")){
               console.log("IMAGE파일..")
               
			   //기존 img 태그 삭제
			   while(profileBoxEl.firstChild){
				profileBoxEl.removeChild(profileBoxEl.firstChild)
			   }
			   
               const imgTg=document.createElement('img')
               imgTg.src=URL.createObjectURL(file)
               imgTg.setAttribute("style","width:100%;height:100%;object-fit:contain;border-radius:50%;")
               profileBoxEl.appendChild(imgTg)
				
			   
			   //
			   formData.append("profileImage",file)
			   
           }
           e.preventDefault();

       })
       