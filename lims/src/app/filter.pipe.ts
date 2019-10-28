import { Pipe, PipeTransform } from '@angular/core';
import { Book } from './book';



@Pipe({
  name: 'filter'
})
export class FilterPipe implements PipeTransform {

  transform(allbooks: Book[],search: string): Book[]{
   if(search===undefined){
     return allbooks;
   }else{
     return allbooks.filter((value,index,array)=>{
       return value.bookName.toLowerCase().includes(search.toLowerCase());
     });
   }
  }

}

