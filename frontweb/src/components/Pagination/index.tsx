import { ReactComponent as ArrowIcon } from 'assets/images/arrow.svg';
import './styles.css';
import ReactPaginate from 'react-paginate';
const Pagination = () => {
  return (
    <ReactPaginate
      pageCount={10}
      pageRangeDisplayed={3}
      marginPagesDisplayed={1}
      containerClassName="pagination-container"
      pageLinkClassName="pagination-item"
      breakClassName="pagination-item"
      previousClassName="arrow-previous"
      previousLabel={<ArrowIcon />}
      nextLabel={<ArrowIcon />}
      nextClassName="arrow-next"
      activeLinkClassName="pagination-link-active "
      disabledClassName="arrow-inactive"
    />
  );
};

export default Pagination;
