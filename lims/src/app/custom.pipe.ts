import { PipeTransform, Pipe } from '@angular/core';
@Pipe({
    name:'cut'
})

export class CutPipe implements PipeTransform{
    transform(value: String ,length:number) {
        return value.substr(0,length)+"...."
    }
    
}
