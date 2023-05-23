const csy_infoTab = document.querySelector('#csy_infoTab');
const csy_reviewTab = document.querySelector('#csy_reviewTab');
const csy_QnATab = document.querySelector('#csy_QnATab');
const csy_dilTab = document.querySelector('#csy_dilTab');
const csy_pickTab = document.querySelector('#csy_pickTab');

const csy_bottomItemInfo = document.querySelector('#csy_bottomItemInfo');
const csy_bottomReview = document.querySelector('#csy_bottomReview');
const csy_bottomQnA = document.querySelector('#csy_bottomQnA');
const csy_bottomDil = document.querySelector('#csy_bottomDil');
const csy_bottomPick = document.querySelector('#csy_bottomPick');

const csy_itemSelect = document.querySelector('#csy_itemSelect');
const csy_itemSelectText = document.querySelector('#csy_itemSelectText');
const csy_Price = document.querySelector('#csy_Price');
const csy_totalPrice = document.querySelector('#csy_totalPrice');
const csy_itemCount = document.querySelector('#csy_itemCount');

const csy_orderBtn = document.querySelector('.csy_btn2');

document.addEventListener('DOMContentLoaded', () => {
  csy_bottomReview.style.display = 'none';
  csy_bottomQnA.style.display = 'none';
  csy_bottomDil.style.display = 'none';
  csy_bottomPick.style.display = 'none';
  csy_infoTab.style.borderBottom = '1px solid black';

  csy_infoTab.addEventListener('click', () => {
    csy_infoTab.style.borderBottom = '1px solid black';
    csy_reviewTab.style.borderBottom = 'none';
    csy_QnATab.style.borderBottom = 'none';
    csy_dilTab.style.borderBottom = 'none';
    csy_pickTab.style.borderBottom = 'none';

    csy_bottomItemInfo.style.display = 'block';
    csy_bottomReview.style.display = 'none';
    csy_bottomQnA.style.display = 'none';
    csy_bottomDil.style.display = 'none';
    csy_bottomPick.style.display = 'none';
  });

  csy_reviewTab.addEventListener('click', () => {
    csy_infoTab.style.borderBottom = 'none';
    csy_reviewTab.style.borderBottom = '1px solid black';
    csy_QnATab.style.borderBottom = 'none';
    csy_dilTab.style.borderBottom = 'none';
    csy_pickTab.style.borderBottom = 'none';

    csy_bottomItemInfo.style.display = 'none';
    csy_bottomReview.style.display = 'block';
    csy_bottomQnA.style.display = 'none';
    csy_bottomDil.style.display = 'none';
    csy_bottomPick.style.display = 'none';
  });

  csy_QnATab.addEventListener('click', () => {
    csy_infoTab.style.borderBottom = 'none';
    csy_reviewTab.style.borderBottom = 'none';
    csy_QnATab.style.borderBottom = '1px solid black';
    csy_dilTab.style.borderBottom = 'none';
    csy_pickTab.style.borderBottom = 'none';

    csy_bottomItemInfo.style.display = 'none';
    csy_bottomReview.style.display = 'none';
    csy_bottomQnA.style.display = 'block';
    csy_bottomDil.style.display = 'none';
    csy_bottomPick.style.display = 'none';
  });
  csy_dilTab.addEventListener('click', () => {
    csy_infoTab.style.borderBottom = 'none';
    csy_reviewTab.style.borderBottom = 'none';
    csy_QnATab.style.borderBottom = 'none';
    csy_dilTab.style.borderBottom = '1px solid black';
    csy_pickTab.style.borderBottom = 'none';

    csy_bottomItemInfo.style.display = 'none';
    csy_bottomReview.style.display = 'none';
    csy_bottomQnA.style.display = 'none';
    csy_bottomDil.style.display = 'block';
    csy_bottomPick.style.display = 'none';
  });
  csy_pickTab.addEventListener('click', () => {
    csy_infoTab.style.borderBottom = 'none';
    csy_reviewTab.style.borderBottom = 'none';
    csy_QnATab.style.borderBottom = 'none';
    csy_dilTab.style.borderBottom = 'none';
    csy_pickTab.style.borderBottom = '1px solid black';

    csy_bottomItemInfo.style.display = 'none';
    csy_bottomReview.style.display = 'none';
    csy_bottomQnA.style.display = 'none';
    csy_bottomDil.style.display = 'none';
    csy_bottomPick.style.display = 'block';
  });

  csy_itemSelect.addEventListener('change', () => {
    csy_itemSelectText.textContent = csy_itemSelect.options[csy_itemSelect.selectedIndex].value;
    csy_itemCount.value = 1;

    const totalPrice = csy_Price.dataset.value * csy_itemCount.value;
    csy_totalPrice.textContent = totalPrice.toLocaleString() + '원';
    if (csy_itemSelect.selectedIndex === 0) {
      csy_totalPrice.textContent = '0원';
      csy_itemCount.value = 0;
    }
  });

  csy_itemCount.addEventListener('change', () => {
    const totalPrice = csy_Price.dataset.value * csy_itemCount.value;
    csy_totalPrice.textContent = totalPrice.toLocaleString() + '원';
  });

  csy_orderBtn.addEventListener('click', (event) => {
    event.preventDefault();

    if (csy_itemCount.value === '0') {
      alert('옵션 선택 후에 버튼을 클릭해 주세요.');
      return;
    }
    window.location.href = 'csy_shoppingOrder.html';
  });
});
