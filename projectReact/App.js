import * as React from 'react';
import TextField from '@mui/material/TextField';
import Avatar from '@mui/material/Avatar';

export default function MyApp() {
  return (
    <div>
     <TextField id="outlined-basic" label="Outlined" variant="outlined" />
     <Avatar alt="Junhee Kang" src="/static/images/avatar/3.jpg" />
    </div>
  );
}

/* CSS는 따로 .css형태를 만들어 className으로 태그이름 지정해 주고 스타일 적용 가능 */

        /*카멜 : className처럼 중간에 대문자를 쓰는 것
        
          from 다음에 폴더 가져올시 ./ 는 현재폴더위치를 나타냄
          html : class            react : className
        */