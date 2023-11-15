package lotto.domain

class Lotto(inputNumberList: List<Int>) {

    val numberList: List<LottoNumber> = inputNumberList.sorted().map { LottoNumber(it) }

    init {
        require(numberList.size == NUMBER_COUNT_MAX) { "로또 번호는 6개만 가능합니다." }

        require(numberList.distinct().size == numberList.size) { "로또 번호는 중복될 수 없습니다." }
    }

    fun getMatchCount(lotto: Lotto): Int = this.numberList.intersect(lotto.numberList.toSet()).size

    private fun isContainsBonusNumber(bonusNumber: LottoNumber): Boolean = this.numberList.any { it == bonusNumber }

    fun getLottoRank(winningLotto: Lotto, bonusNumber: LottoNumber): LottoRank {
        val matchCount: Int = this.getMatchCount(winningLotto)
        val lottoRank: LottoRank = LottoRank.findByMatchCount(matchCount)

        return if (matchCount == 5) {
            if (this.isContainsBonusNumber(bonusNumber)) LottoRank.SECOND_WITH_BONUS else LottoRank.SECOND
        } else {
            lottoRank
        }
    }

    companion object {
        const val LOTTO_PRICE: Int = 1000
        const val LOTTO_NUMBER_MIN: Int = 1
        const val LOTTO_NUMBER_MAX: Int = 45
        const val NUMBER_COUNT_MIN: Int = 0
        const val NUMBER_COUNT_MAX: Int = 6
    }
}
